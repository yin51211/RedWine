package com.wafersystems.cloud.orders.model;

import com.wafersystems.cloud.model.OrderInfo;

import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
public interface IOrderDao {

    public void saveOrder(OrderInfo orderInfo);

    public void updateOrder(OrderInfo orderInfo);

    public List<OrderInfo> getAllOrder();

    public void deleteOrder(String orderNumber);

    public void updateOrderState(String orderNumber,int statusNumber);
}
