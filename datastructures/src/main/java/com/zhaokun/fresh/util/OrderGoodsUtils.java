package com.zhaokun.fresh.util;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.zhaokun.test.PriceUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import static com.zhaokun.test.CountTest.getMagnificationValue;

/**
 * @author zhaok
 * @Date 2022/2/23 10:11
 */
@Slf4j
public class OrderGoodsUtils {


    /**
     * 价格系数
     * @param curPrice
     * @param afterPrice
     * @param perMagnificationValue
     * @return
     */
    public static String getPriceCoefficient(String curPrice, String afterPrice, String perMagnificationValue) {
        int comparePrice = PriceUtil.comparePrice(curPrice, afterPrice);
        int abs = Math.abs(comparePrice);
        String magnificationValue = "1";
        if (abs != 0) {
            String oper = PriceUtil.oper(curPrice, afterPrice);
            log.info("运算符：" + oper);
            magnificationValue = getMagnificationValue(perMagnificationValue, oper, abs);
        }
        return magnificationValue;
    }

    /**
     * 理论推荐订货量
     * @param turnoverOrderRate 周转订货倍率
     * @param afterWeekCustomerRate  明天的周客流系数
     * @param changePriceAverageSale  变价前同价日均销售
     * @param afterPriceCoefficient 明天的价格系数
     * @param afterDisplayArea 明天的陈列面积
     * @param displayPositionRate 陈列落位系数
     * @param theoryEffectiveInventory 理论有效库存
     * @return
     */
    public static BigDecimal getTheoryRecommendOrderQuantity(double turnoverOrderRate,
                                                             double afterWeekCustomerRate,
                                                             BigDecimal changePriceAverageSale,
                                                             double afterPriceCoefficient,
                                                             Integer afterDisplayArea,
                                                             Double displayPositionRate,
                                                             BigDecimal theoryEffectiveInventory) {

        // 当天的 周转订货倍率 * (1 + 理论损耗比例)
        double mul = NumberUtil.mul(turnoverOrderRate, 1.05);
        BigDecimal mul1 = NumberUtil.mul(afterWeekCustomerRate, changePriceAverageSale, afterPriceCoefficient,
                afterDisplayArea, displayPositionRate);
        BigDecimal mul2 = NumberUtil.mul(mul, mul1);
        BigDecimal theoryRecommendOrderQuantity = NumberUtil.add(mul2, theoryEffectiveInventory);
        return theoryRecommendOrderQuantity;
    }

    /**
     * 变价前同价日均销售
     *
     * @param orderQuantity 当天的正价销售量
     * @param goodsNormalPriceQuantity 正价销售量集合
     * @return
     */
    public static BigDecimal getChangePriceAverageSale(BigDecimal orderQuantity, List<BigDecimal> goodsNormalPriceQuantity) {
        if (CollectionUtils.isEmpty(goodsNormalPriceQuantity)) {
            return orderQuantity;
        }
        BigDecimal add = NumberUtil.add(goodsNormalPriceQuantity.toArray(new String[goodsNormalPriceQuantity.size()]));
        return NumberUtil.div(add, goodsNormalPriceQuantity.size());

    }

    /**
     * 陈列面积系数
     * （暂时全部取1）
     * @param curDisplayArea
     * @param preDisplayArea
     * @return
     */
    public static Integer getDisplayAreaRate(Integer curDisplayArea, Integer preDisplayArea) {
        return 1;
    }

    /**
     * 陈列落位系数 = 前一天的 陈列落位 / 当前的 陈列落位
     * @return
     */
    public static Double getDisplayPositionRate(Double preDisplayPosition, Double cruDisplayPosition) {
        return NumberUtil.div(preDisplayPosition, cruDisplayPosition);
    }

    /**
     * 理论有效库存
     * （前两天的 实际订货量 - 前一天 正价销售量 - 当天的 预估当日销售量）
     * @return
     */
    public static BigDecimal getTheoryEffectiveInventory(BigDecimal twoOrderQuantity,
                                                         BigDecimal preGoodsNormalPriceQuantity,
                                                         Double estimatedSaleQuantity) {
        BigDecimal mul = NumberUtil.mul(twoOrderQuantity, preGoodsNormalPriceQuantity, estimatedSaleQuantity);
        if (NumberUtil.isLess(mul, BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return mul;

    }

    /**
     * 预估当日销售量）
     *
     * 预估当日销售量 = =(U7+Q7)/E7 = (前一天 实际订货量 + 前一天 理论有效库存) / 周转订货倍率
     * 周转订货倍率 最佳周转天数一天对应的订货倍率也是1，最佳周转天数是2天的，
     * 对应的订货倍率是1.3。最佳周转天数三天及三天以上的订货倍率是1.5。
     */
    public static Double getEstimatedSaleQuantity(BigDecimal preOrderQuantity, Double preTheoryEffectiveInventory) {
        BigDecimal mul = NumberUtil.mul(preOrderQuantity, preTheoryEffectiveInventory);
        BigDecimal div = NumberUtil.div(mul, 1.3);
        return div.doubleValue();

    }

    /**
     * 最小箱规订货倍率 = 理论推荐订货量 * 最小箱规
     * @return
     */
    public static BigDecimal getSmallGaugeOrderRate(BigDecimal theoryRecommendOrderQuantity,
                                                    Integer smallGaugeBox) {

        return NumberUtil.mul(theoryRecommendOrderQuantity, smallGaugeBox);

    }

    /**
     * 最小箱规进位后倍率 = 最小箱规订货倍率 + 0.7 (取整形)
     * @return
     */
    public static BigDecimal getSmallGaugeAfterRate(BigDecimal smallGaugeOrderRate) {
        return NumberUtil.add(smallGaugeOrderRate, new BigDecimal("0.7"));
    }

    /**
     * order_quantity
     *
     * 实际订货量：T6*X6 = 最小箱规进位后倍率 * 最小箱规
     */
    public static BigDecimal getOrderQuantity(BigDecimal smallGaugeAfterRate, Integer smallGauge) {
        return NumberUtil.mul(smallGaugeAfterRate, smallGauge);

    }

    /**
     * 订货准确率分析
     * 周转订货倍率 * (正价销售量 + 正价销售量 * 理论损耗比例) / (实际订货量 * 理论有效库存)
     * 理论损耗比例 固定5%
     * @return
     */
    public static BigDecimal getOrderAccuracyRate(Double turnoverOrderRate, BigDecimal goodsNormalPriceQuantity,
                                           BigDecimal orderQuantity, BigDecimal theoryEffectiveInventory) {
        BigDecimal mul = NumberUtil.mul(goodsNormalPriceQuantity, 0.05);
        BigDecimal add = NumberUtil.add(mul, goodsNormalPriceQuantity);
        BigDecimal mul1 = NumberUtil.mul(turnoverOrderRate, add);
        BigDecimal mul2 = NumberUtil.mul(orderQuantity, theoryEffectiveInventory);
        BigDecimal div = NumberUtil.div(mul1, mul2);
        return div;
    }

    /**
     * 周转订货倍率
     * @return
     */
    public static Double getTurnoverOrderRate(int bestTurnoverDays) {
        double v;
        switch (bestTurnoverDays) {
            case 1:
                v = 1.0d;
                break;
            case 2:
                v = 1.3d;
                break;
            default:
                v = 1.5;
                break;
        }
        return v;
    }

    /**
     * 周客流系数
     * @param dateTime
     * @return
     */
    public static double getWeekCustomerRate(LocalDateTime dateTime) {
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        int dayOfWeekValue = dayOfWeek.getValue();
        double value = 1;
        /**
         * 0.98 1
         * 0.99 2
         * 1.02 3
         * 0.95 4
         * 1.01 5
         * 1.02 6
         * 1.02 7
         */
        switch (dayOfWeekValue) {
            case 1:
                value = 0.98;
                break;
            case 2:
                value = 0.99;
                break;
            case 4:
                value = 0.95;
                break;
            case 5:
                value = 1.01;
                break;
            default:
                value = 1.02;

        }
        return value;
    }

    public static void main(String[] args) {

        System.out.println(getPriceCoefficient("1.0", "2.0", "1"));

    }


}