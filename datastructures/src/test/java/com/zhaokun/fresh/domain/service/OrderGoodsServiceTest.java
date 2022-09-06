package com.zhaokun.fresh.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhaokun.fresh.domain.OrderGoods;
import com.zhaokun.fresh.mapper.OrderGoodsMapper;
import com.zhaokun.fresh.util.OrderGoodsUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderGoodsServiceTest {

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    /**
     * 计算价格系数
     */
    @Test
    public void testPriceCoefficient() {

    }

    @Test
    public void populatingBaseData() {
        LambdaQueryWrapper<OrderGoods> orderGoodsLambdaQueryWrapper = Wrappers.lambdaQuery(OrderGoods.class);
        List<OrderGoods> orderGoodsList = orderGoodsMapper.selectList(orderGoodsLambdaQueryWrapper);
        for (OrderGoods orderGoods : orderGoodsList) {
            OrderGoods beforeOrderGoods = orderGoodsMapper.selectOne(Wrappers.lambdaQuery(OrderGoods.class)
                    .lt(OrderGoods::getId, orderGoods.getId())
                    .orderByDesc(OrderGoods::getCreateTime).last("limit 1"));
            OrderGoods beforeTwoOrderGoods = orderGoodsMapper.selectOne(Wrappers.lambdaQuery(OrderGoods.class)
                    .lt(OrderGoods::getId, beforeOrderGoods.getId())
                    .orderByDesc(OrderGoods::getCreateTime).last("limit 1"));
            OrderGoods afterOrderGoods = orderGoodsMapper.selectOne(Wrappers.lambdaQuery(OrderGoods.class)
                    .gt(OrderGoods::getId, orderGoods.getId()).last("limit 1"));
            Double displayPositionRate = OrderGoodsUtils.
                    getDisplayPositionRate(beforeOrderGoods.getDisplayPosition(), orderGoods.getDisplayPosition());
            orderGoods.setDisplayPosition(displayPositionRate);
            // 陈列落位系数
//        Double displayPositionRate = orderGoods.getDisplayPositionRate();
            // 价格系数
            String priceCoefficient = OrderGoodsUtils.getPriceCoefficient(orderGoods.getGoodsPrice().toString(),
                    afterOrderGoods.getGoodsPrice().toString(),
                    beforeOrderGoods.getPriceCoefficient().toString());
//        Double priceCoefficient = orderGoods.getPriceCoefficient();


        }

    }


}