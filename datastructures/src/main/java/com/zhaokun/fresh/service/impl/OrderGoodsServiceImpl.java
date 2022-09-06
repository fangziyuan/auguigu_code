package com.zhaokun.fresh.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaokun.fresh.OrderGoodsDTO;
import com.zhaokun.fresh.domain.OrderGoods;
import com.zhaokun.fresh.domain.Vegetable;
import com.zhaokun.fresh.mapper.OrderGoodsMapper;
import com.zhaokun.fresh.mapper.VegetableMapper;
import com.zhaokun.fresh.service.OrderGoodsService;
import com.zhaokun.fresh.util.OrderGoodsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author zhaok
* @description 针对表【order_goods】的数据库操作Service实现
* @createDate 2022-02-23 09:50:02
*/
@Service
@Slf4j
public class OrderGoodsServiceImpl extends ServiceImpl<OrderGoodsMapper, OrderGoods>
    implements OrderGoodsService {

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Autowired
    private VegetableMapper vegetableMapper;

    /**
     * 计算订单订货信息
     *
     * @param orderGoodsDTO
     */
    @Override
    public void calculateOrderInfo(OrderGoodsDTO orderGoodsDTO) {
        LambdaQueryWrapper<OrderGoods> orderGoodsLambdaQueryWrapper = Wrappers.lambdaQuery(OrderGoods.class);
        List<OrderGoods> orderGoodsList = orderGoodsMapper.selectList(orderGoodsLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(orderGoodsList)) {
            return;
        }
        List<Vegetable> vegetables = vegetableMapper.selectList(Wrappers.lambdaQuery(Vegetable.class));
        Map<String, Integer> vegetableMap = vegetables.stream().collect(Collectors.toMap(Vegetable::getGoodsNo, Vegetable::getBestTurnoverDays));
        for (OrderGoods orderGoods : orderGoodsList) {
            LocalDateTime createTime = orderGoods.getCreateTime();
            String goodsNo = orderGoods.getGoodsNo();
            int getBestTurnoverDays = vegetableMap.getOrDefault(goodsNo, 1);
            // 周转订货倍率
            double turnoverOrderRate = OrderGoodsUtils.getTurnoverOrderRate(getBestTurnoverDays);

            // 变价前同价日均销售 获取当前价格前1-7天的正价销售量
            // 首先获取当前行的前面所有行，再获取最后的7条数据，再比较价格是否相等
            List<OrderGoods> orderGoodsBeforeList = orderGoodsMapper.selectList(Wrappers.lambdaQuery(OrderGoods.class)
                    .lt(OrderGoods::getId, orderGoods.getId())
                    .orderByAsc(OrderGoods::getCreateTime));
            List<BigDecimal> goodsNormalPriceQuantityList = getGoodsNormanPriceQuantity(orderGoods.getGoodsPrice(), orderGoodsBeforeList);
            // 变价前同价日均销售
            BigDecimal changePriceAverageSale = OrderGoodsUtils.
                    getChangePriceAverageSale(orderGoods.getOrderQuantity(), goodsNormalPriceQuantityList);

            // 陈列落位系数
            Double displayPositionRate = orderGoods.getDisplayPositionRate();
            // 明天的周客流系数
            double weekCustomerAfterRate = OrderGoodsUtils.getWeekCustomerRate(createTime.plusDays(1L));

            // 前一天的订单信息
            OrderGoods beforeOrderGoods = orderGoodsMapper.selectOne(Wrappers.lambdaQuery(OrderGoods.class)
                    .lt(OrderGoods::getId, orderGoods.getId())
                    .orderByDesc(OrderGoods::getCreateTime).last("limit 1"));

            // 前两天的订单信息
            OrderGoods beforeTwoOrderGoods = orderGoodsMapper.selectOne(Wrappers.lambdaQuery(OrderGoods.class)
                    .lt(OrderGoods::getId, beforeOrderGoods.getId())
                    .orderByDesc(OrderGoods::getCreateTime).last("limit 1"));
            // 明天的价格系数
            OrderGoods afterOrderGoods = orderGoodsMapper.selectOne(Wrappers.lambdaQuery(OrderGoods.class)
                    .gt(OrderGoods::getId, orderGoods.getId()).last("limit 1"));
            // 最后一天获取明天的价格系数，是获取不到的，用最后一天的价格系数
            if (Objects.isNull(afterOrderGoods)) {
                afterOrderGoods = orderGoods;
            }
            // 明天的价格系数
            Double afterPriceCoefficient = afterOrderGoods.getPriceCoefficient();
            // 明天的陈列面积
            Integer afterDisplayArea = afterOrderGoods.getDisplayArea();
            // 理论有效库存
            // （前两天的 实际订货量 - 前一天 正价销售量 - 当天的 预估当日销售量）
            BigDecimal beforeOrderQuantityTotal = NumberUtil.add(beforeTwoOrderGoods.getOrderQuantity(), beforeOrderGoods.getOrderQuantity());
            // 预估当日销售量 (前一天 实际订货量 + 前一天 理论有效库存) / 周转订货倍率
            Double estimatedSaleQuantity = OrderGoodsUtils.getEstimatedSaleQuantity(beforeOrderGoods.getOrderQuantity(),
                    beforeOrderGoods.getTheoryEffectiveInventory());
            BigDecimal theoryEffectiveInventory = OrderGoodsUtils
                    .getTheoryEffectiveInventory(beforeOrderQuantityTotal,
                            beforeOrderGoods.getGoodsNormalPriceQuantity(),
                            estimatedSaleQuantity);



            /**
             * 理论推荐订货量
             *
             * * @param turnoverOrderRate 周转订货倍率
             *      * @param afterWeekCustomerRate  明天的周客流系数
             *      * @param changePriceAverageSale  变价前同价日均销售
             *      * @param afterPriceCoefficient 明天的价格系数
             *      * @param afterDisplayArea 明天的陈列面积
             *      * @param displayPositionRate 陈列落位系数
             *      * @param theoryEffectiveInventory 理论有效库存
             */
            BigDecimal theoryRecommendOrderQuantity = OrderGoodsUtils.getTheoryRecommendOrderQuantity(turnoverOrderRate,
                    weekCustomerAfterRate, changePriceAverageSale, afterPriceCoefficient,
                    afterDisplayArea, displayPositionRate,
                    theoryEffectiveInventory);

            // 最小箱规订货倍率
            BigDecimal smallGaugeOrderRate = OrderGoodsUtils.getSmallGaugeOrderRate(theoryRecommendOrderQuantity, orderGoods.getSmallGaugeBox());
            // 最小箱规进位后倍率
            BigDecimal smallGaugeAfterRate = OrderGoodsUtils.getSmallGaugeAfterRate(smallGaugeOrderRate);
            // 实际订货量
            BigDecimal orderQuantity = OrderGoodsUtils.getOrderQuantity(smallGaugeAfterRate, orderGoods.getSmallGaugeBox());
            // 订货准确率分析 周转订货倍率 * (正价销售量 + 正价销售量* 理论损耗比例) / (实际订货量 * 理论有效库存)
            BigDecimal orderAccuracyRate = OrderGoodsUtils.getOrderAccuracyRate(turnoverOrderRate,
                    orderGoods.getGoodsNormalPriceQuantity(), orderQuantity, theoryEffectiveInventory);

            OrderGoods build = OrderGoods.builder()
                    .smallGaugeOrderAfterRate(smallGaugeAfterRate)
                    .displayPositionRate(displayPositionRate)
                    .turnoverOrderRate(turnoverOrderRate)
                    .changePriceAverageSale(changePriceAverageSale)
                    .smallGaugeOrderRate(smallGaugeOrderRate)
                    .theoryRecommendOrderQuantity(theoryRecommendOrderQuantity)
                    .orderAccuracyRate(orderAccuracyRate)
                    .weekCustomerRate(OrderGoodsUtils.getWeekCustomerRate(createTime))
                    .build();
            boolean save = this.save(build);
            log.info("结果： {}", save);

        }
    }


    /**
     * 获取前七天相同价格列表
     * @param goodsPrice
     * @param orderGoodsBeforeList
     * @return
     */
    private static List<BigDecimal> getGoodsNormanPriceQuantity(BigDecimal goodsPrice, List<OrderGoods> orderGoodsBeforeList) {
        List<BigDecimal> value = new ArrayList<>();
        if (CollectionUtils.isEmpty(orderGoodsBeforeList)) {
            return value;
        }
        int size = orderGoodsBeforeList.size();
        int index = size - 7;
        if (index <= 0) {
            index = 0;
        }
        List<OrderGoods> orderGoodsList = orderGoodsBeforeList.subList(index, size);
        for (int i = size; i >= index ; i--) {
            OrderGoods orderGoods = orderGoodsList.get(i);
            if (NumberUtil.equals(goodsPrice, orderGoods.getGoodsPrice())) {
                value.add(orderGoods.getGoodsPrice());
            } else {
                break;
            }
        }
        return value;
    }
}




