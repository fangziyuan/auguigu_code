package com.zhaokun.fresh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaokun.fresh.OrderGoodsDTO;
import com.zhaokun.fresh.domain.OrderGoods;

/**
* @author zhaok
* @description 针对表【order_goods】的数据库操作Service
* @createDate 2022-02-23 09:50:02
*/
public interface OrderGoodsService extends IService<OrderGoods> {

    /**
     * 计算订单订货信息
     */
    void calculateOrderInfo(OrderGoodsDTO orderGoodsDTO);

}
