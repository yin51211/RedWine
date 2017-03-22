package com.wafersystems.cloud.orders.service.impl;

import com.wafersystems.cloud.model.OrderInfo;
import com.wafersystems.cloud.orders.model.IOrderDao;
import com.wafersystems.cloud.orders.service.IOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {

    private static final Logger LOGGER = Logger
            .getLogger(OrderServiceImpl.class);
    @Resource
    private IOrderDao orderDao;
    @Autowired
    private ApplicationContext resource;

    @Override
    public Object saveOrder(OrderInfo order) {
        if (order != null) {
            orderDao.saveOrder(order);
            return "su";
        } else
            return null;
    }

    @Override
    public List<OrderInfo> getAllOrders() {
        return orderDao.getAllOrder();
    }

    @Override
    public void updateOrderState(String orderNumber, int statusNumber) {
        orderDao.updateOrderState(orderNumber,statusNumber);
    }

    @Override
    public void updateOrders(OrderInfo order) {
        orderDao.updateOrder(order);
    }
}
