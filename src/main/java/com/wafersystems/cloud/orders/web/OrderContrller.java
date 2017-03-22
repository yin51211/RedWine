package com.wafersystems.cloud.orders.web;

import com.wafersystems.cloud.manage.service.IGoodsService;
import com.wafersystems.cloud.orders.service.IOrderService;
import com.wafersystems.cloud.orders.service.IShoppingCartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
@Controller
@RequestMapping("/caas/orders")
public class OrderContrller {

    private static final Logger LOGGER = Logger
            .getLogger(OrderContrller.class);
    @Autowired
    IGoodsService goodsService;
    @Autowired
    IShoppingCartService shoppingCartServic;
    @Autowired
    IOrderService orderService;





}
