package com.zhaokun.fresh.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName vegetable
 */
@TableName(value ="vegetable")
@Data
public class Vegetable implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编码
     */
    @TableField(value = "goods_no")
    private String goodsNo;

    /**
     * 商品条形码
     */
    @TableField(value = "goods_bar_code")
    private String goodsBarCode;

    /**
     * 商品名称
     */
    @TableField(value = "goods_name")
    private String goodsName;

    /**
     * 最佳周转天数
     */
    @TableField(value = "best_turnover_days")
    private Integer bestTurnoverDays;

    /**
     * 理论损耗率
     */
    @TableField(value = "theory_attrition_rate")
    private Integer theoryAttritionRate;

    /**
     * 分类
     */
    @TableField(value = "category_id")
    private Integer categoryId;

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
        Vegetable other = (Vegetable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsNo() == null ? other.getGoodsNo() == null : this.getGoodsNo().equals(other.getGoodsNo()))
            && (this.getGoodsBarCode() == null ? other.getGoodsBarCode() == null : this.getGoodsBarCode().equals(other.getGoodsBarCode()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getBestTurnoverDays() == null ? other.getBestTurnoverDays() == null : this.getBestTurnoverDays().equals(other.getBestTurnoverDays()))
            && (this.getTheoryAttritionRate() == null ? other.getTheoryAttritionRate() == null : this.getTheoryAttritionRate().equals(other.getTheoryAttritionRate()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsNo() == null) ? 0 : getGoodsNo().hashCode());
        result = prime * result + ((getGoodsBarCode() == null) ? 0 : getGoodsBarCode().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getBestTurnoverDays() == null) ? 0 : getBestTurnoverDays().hashCode());
        result = prime * result + ((getTheoryAttritionRate() == null) ? 0 : getTheoryAttritionRate().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
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
        sb.append(", goodsBarCode=").append(goodsBarCode);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", bestTurnoverDays=").append(bestTurnoverDays);
        sb.append(", theoryAttritionRate=").append(theoryAttritionRate);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}