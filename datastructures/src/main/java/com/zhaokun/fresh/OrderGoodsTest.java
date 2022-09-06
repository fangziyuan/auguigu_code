package com.zhaokun.fresh;



import com.zhaokun.fresh.domain.OrderGoods;
import java.math.BigDecimal;

/**
 * @author zhaok
 * @Date 2022/2/20 21:52
 */
public class OrderGoodsTest {

    public static void main(String[] args) {


        OrderGoods build = OrderGoodsDTO.builder().build();

        OrderGoods orderGoods = OrderGoods.builder().build();

        /**
         * 实际订货量：T6*X6 = 最小箱规进位后倍率 * 最小箱规
         *
         * 最小箱规进位后倍率 = 最小箱规订货倍率 + 0.7 (取整形)
         *
         * 最小箱规订货倍率 = 理论推荐订货量 * 最小箱规
         */
        /**
         * 实际订货量
         */
        int orderQuantity = 0;
        /**
         * 最小箱规进位后倍率
         */
        int smallGaugeBoxOrderRate = 0;

        /**
         * 理论推荐订货量
         */
        BigDecimal theoryRecommendOrderQuantity;

        /**
         * 周转订货倍率
         */
        int turnoverOrderRate = 0;

        /**
         * 理论损耗率
         */
        int theoryAttritionRate = 5;

        /**
         * 周客流系数
         */
        float weekCustomerRate = 1.0f;

        /**
         * 变价前同价日均销售
         */
        float changePriceAverageSale = 23.0f;

        /**
         * 价格系数
         */
        float priceCoefficient = 1.0f;

        /**
         * 陈列面积
         */
        Integer displayArea = orderGoods.getDisplayArea();

        /**
         * 陈列落位
         */
        Double displayPosition = orderGoods.getDisplayPosition();

        /**
         * 陈列落位系数
         */
        Double displayPositionRate = 0d;

        /**
         * 理论有效库存 需要计算 （前两天的 实际订货量 - 前一天 正价销售量 - 当天的 预估当日销售量）
         */
        float theoryEffectiveInventory = 20.0f;

        /**
         * 预估当日销售量）
         *
         * 预估当日销售量 = =(U7+Q7)/E7 = (前一天 实际订货量 + 前一天 理论有效库存) / 周转订货倍率
         */
//        float estimatedSaleQuantity =

        /**
         * 最小箱规订货倍率
         */
        double smallGaugeOrderRate = 0;

        /**
         * 最小箱规进位后倍率
         */
        double smallGaugeOrderAfterRate = 0;

    }



}