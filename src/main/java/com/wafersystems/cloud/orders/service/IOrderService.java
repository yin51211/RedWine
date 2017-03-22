package com.wafersystems.cloud.orders.service;

import com.wafersystems.cloud.model.OrderInfo;

import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
public interface IOrderService {
    public Object saveOrder(OrderInfo order);

    public List<OrderInfo> getAllOrders();

    public void updateOrderState(String orderNumber,int statusNumber);

    public void updateOrders(OrderInfo order);
}
