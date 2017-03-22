package com.wafersystems.cloud.orders.service.impl;

import com.wafersystems.cloud.model.ShoppingCart;
import com.wafersystems.cloud.orders.model.IShoppingCartDao;
import com.wafersystems.cloud.orders.service.IShoppingCartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
@Service(value = "shoppingCartServic")
public class ShoppingCartServiceImpl implements IShoppingCartService {

    private static final Logger LOGGER = Logger
            .getLogger(ShoppingCartServiceImpl.class);

    @Autowired
    private ApplicationContext resource;
    @Resource
    private IShoppingCartDao shoppingDao;

    @Override
    public Object saveShopingCart(ShoppingCart shoppingCart) {
        if(shoppingCart!=null) {
            shoppingDao.saveShoppingCart(shoppingCart);
            return "su";
        }else
            return null;
    }

    @Override
    public List<ShoppingCart> getAllCart() {
        return shoppingDao.getAllCart();
    }

    @Override
    public int getProductQuantity() {
        return shoppingDao.getProductQuantity();
    }

    @Override
    public Object deleteCart(ShoppingCart cart) {
        if(cart!=null) {
            shoppingDao.deleteCart(cart);
            return "su";
        }else
            return null;
    }

    @Override
    public Object updateCart(ShoppingCart cart) {
        if(cart!=null) {
            shoppingDao.updateCart(cart);
            return "su";
        }else
            return null;
    }

    @Override
    public void deleteAll() {
        shoppingDao.deleteAll();
    }

    @Override
    public ShoppingCart getByProductID(Long productID) {
        return shoppingDao.getCartShoppingByProductID(productID);
    }
}
