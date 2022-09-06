package com.zhaokun.fresh.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 
 * @TableName order_goods
 */
@TableName(value ="order_goods")
@Data
@Builder
public class OrderGoods implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编码
     */
    @TableField(value = "goods_no")
    private String goodsNo;

    /**
     * 商品名称
     */
    @TableField(value = "goods_name")
    private String goodsName;

    /**
     * 商品定价
     */
    @TableField(value = "goods_price")
    private BigDecimal goodsPrice;

    /**
     * 正价销售量
     */
    @TableField(value = "goods_normal_price_quantity")
    private BigDecimal goodsNormalPriceQuantity;

    /**
     * 价格系数
     */
    @TableField(value = "price_coefficient")
    private Double priceCoefficient;

    /**
     * 陈列面积
     */
    @TableField(value = "display_area")
    private Integer displayArea;

    /**
     * 陈列落位
     */
    @TableField(value = "display_position")
    private Double displayPosition;

    /**
     * 陈列落位系数
     */
    @TableField(value = "display_position_rate")
    private Double displayPositionRate;

    /**
     * 周转订货倍率
     */
    @TableField(value = "turnover_order_rate")
    private Double turnoverOrderRate;

    /**
     * 理论损耗率
     */
    @TableField(value = "theory_attrition_rate")
    private Double theoryAttritionRate;

    /**
     * 周客流系数
     */
    @TableField(value = "week_customer_rate")
    private Double weekCustomerRate;

    /**
     * 变价前同价日均销售
     */
    @TableField(value = "change_price_average_sale")
    private BigDecimal changePriceAverageSale;

    /**
     * 理论有效库存
     */
    @TableField(value = "theory_effective_inventory")
    private Double theoryEffectiveInventory;

    /**
     * 预估当日销售量
     */
    @TableField(value = "estimated_sale_quantity")
    private Double estimatedSaleQuantity;

    /**
     * 最小规箱
     */
    @TableField(value = "small_gauge_box")
    private Integer smallGaugeBox;

    /**
     * 最小箱规订货倍率
     */
    @TableField(value = "small_gauge_order_rate")
    private BigDecimal smallGaugeOrderRate;

    /**
     * 最小箱规进位后倍率
     */
    @TableField(value = "small_gauge_order_after_rate")
    private BigDecimal smallGaugeOrderAfterRate;

    /**
     * 理论推荐订货量
     */
    @TableField(value = "theory_recommend_order_quantity")
    private BigDecimal theoryRecommendOrderQuantity;

    /**
     * 实际订货量
     */
    @TableField(value = "order_quantity")
    private BigDecimal orderQuantity;

    /**
     * 订货准确率
     */
    @TableField(value = "order_accuracy_rate")
    private BigDecimal orderAccuracyRate;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderGoods other = (OrderGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsNo() == null ? other.getGoodsNo() == null : this.getGoodsNo().equals(other.getGoodsNo()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsPrice() == null ? other.getGoodsPrice() == null : this.getGoodsPrice().equals(other.getGoodsPrice()))
            && (this.getGoodsNormalPriceQuantity() == null ? other.getGoodsNormalPriceQuantity() == null : this.getGoodsNormalPriceQuantity().equals(other.getGoodsNormalPriceQuantity()))
            && (this.getPriceCoefficient() == null ? other.getPriceCoefficient() == null : this.getPriceCoefficient().equals(other.getPriceCoefficient()))
            && (this.getDisplayArea() == null ? other.getDisplayArea() == null : this.getDisplayArea().equals(other.getDisplayArea()))
            && (this.getDisplayPosition() == null ? other.getDisplayPosition() == null : this.getDisplayPosition().equals(other.getDisplayPosition()))
            && (this.getDisplayPositionRate() == null ? other.getDisplayPositionRate() == null : this.getDisplayPositionRate().equals(other.getDisplayPositionRate()))
            && (this.getTurnoverOrderRate() == null ? other.getTurnoverOrderRate() == null : this.getTurnoverOrderRate().equals(other.getTurnoverOrderRate()))
            && (this.getTheoryAttritionRate() == null ? other.getTheoryAttritionRate() == null : this.getTheoryAttritionRate().equals(other.getTheoryAttritionRate()))
            && (this.getWeekCustomerRate() == null ? other.getWeekCustomerRate() == null : this.getWeekCustomerRate().equals(other.getWeekCustomerRate()))
            && (this.getChangePriceAverageSale() == null ? other.getChangePriceAverageSale() == null : this.getChangePriceAverageSale().equals(other.getChangePriceAverageSale()))
            && (this.getTheoryEffectiveInventory() == null ? other.getTheoryEffectiveInventory() == null : this.getTheoryEffectiveInventory().equals(other.getTheoryEffectiveInventory()))
            && (this.getEstimatedSaleQuantity() == null ? other.getEstimatedSaleQuantity() == null : this.getEstimatedSaleQuantity().equals(other.getEstimatedSaleQuantity()))
            && (this.getSmallGaugeBox() == null ? other.getSmallGaugeBox() == null : this.getSmallGaugeBox().equals(other.getSmallGaugeBox()))
            && (this.getSmallGaugeOrderRate() == null ? other.getSmallGaugeOrderRate() == null : this.getSmallGaugeOrderRate().equals(other.getSmallGaugeOrderRate()))
            && (this.getSmallGaugeOrderAfterRate() == null ? other.getSmallGaugeOrderAfterRate() == null : this.getSmallGaugeOrderAfterRate().equals(other.getSmallGaugeOrderAfterRate()))
            && (this.getTheoryRecommendOrderQuantity() == null ? other.getTheoryRecommendOrderQuantity() == null : this.getTheoryRecommendOrderQuantity().equals(other.getTheoryRecommendOrderQuantity()))
            && (this.getOrderQuantity() == null ? other.getOrderQuantity() == null : this.getOrderQuantity().equals(other.getOrderQuantity()))
            && (this.getOrderAccuracyRate() == null ? other.getOrderAccuracyRate() == null : this.getOrderAccuracyRate().equals(other.getOrderAccuracyRate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsNo() == null) ? 0 : getGoodsNo().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsPrice() == null) ? 0 : getGoodsPrice().hashCode());
        result = prime * result + ((getGoodsNormalPriceQuantity() == null) ? 0 : getGoodsNormalPriceQuantity().hashCode());
        result = prime * result + ((getPriceCoefficient() == null) ? 0 : getPriceCoefficient().hashCode());
        result = prime * result + ((getDisplayArea() == null) ? 0 : getDisplayArea().hashCode());
        result = prime * result + ((getDisplayPosition() == null) ? 0 : getDisplayPosition().hashCode());
        result = prime * result + ((getDisplayPositionRate() == null) ? 0 : getDisplayPositionRate().hashCode());
        result = prime * result + ((getTurnoverOrderRate() == null) ? 0 : getTurnoverOrderRate().hashCode());
        result = prime * result + ((getTheoryAttritionRate() == null) ? 0 : getTheoryAttritionRate().hashCode());
        result = prime * result + ((getWeekCustomerRate() == null) ? 0 : getWeekCustomerRate().hashCode());
        result = prime * result + ((getChangePriceAverageSale() == null) ? 0 : getChangePriceAverageSale().hashCode());
        result = prime * result + ((getTheoryEffectiveInventory() == null) ? 0 : getTheoryEffectiveInventory().hashCode());
        result = prime * result + ((getEstimatedSaleQuantity() == null) ? 0 : getEstimatedSaleQuantity().hashCode());
        result = prime * result + ((getSmallGaugeBox() == null) ? 0 : getSmallGaugeBox().hashCode());
        result = prime * result + ((getSmallGaugeOrderRate() == null) ? 0 : getSmallGaugeOrderRate().hashCode());
        result = prime * result + ((getSmallGaugeOrderAfterRate() == null) ? 0 : getSmallGaugeOrderAfterRate().hashCode());
        result = prime * result + ((getTheoryRecommendOrderQuantity() == null) ? 0 : getTheoryRecommendOrderQuantity().hashCode());
        result = prime * result + ((getOrderQuantity() == null) ? 0 : getOrderQuantity().hashCode());
        result = prime * result + ((getOrderAccuracyRate() == null) ? 0 : getOrderAccuracyRate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsNo=").append(goodsNo);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsNormalPriceQuantity=").append(goodsNormalPriceQuantity);
        sb.append(", priceCoefficient=").append(priceCoefficient);
        sb.append(", displayArea=").append(displayArea);
        sb.append(", displayPosition=").append(displayPosition);
        sb.append(", displayPositionRate=").append(displayPositionRate);
        sb.append(", turnoverOrderRate=").append(turnoverOrderRate);
        sb.append(", theoryAttritionRate=").append(theoryAttritionRate);
        sb.append(", weekCustomerRate=").append(weekCustomerRate);
        sb.append(", changePriceAverageSale=").append(changePriceAverageSale);
        sb.append(", theoryEffectiveInventory=").append(theoryEffectiveInventory);
        sb.append(", estimatedSaleQuantity=").append(estimatedSaleQuantity);
        sb.append(", smallGaugeBox=").append(smallGaugeBox);
        sb.append(", smallGaugeOrderRate=").append(smallGaugeOrderRate);
        sb.append(", smallGaugeOrderAfterRate=").append(smallGaugeOrderAfterRate);
        sb.append(", theoryRecommendOrderQuantity=").append(theoryRecommendOrderQuantity);
        sb.append(", orderQuantity=").append(orderQuantity);
        sb.append(", orderAccuracyRate=").append(orderAccuracyRate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}