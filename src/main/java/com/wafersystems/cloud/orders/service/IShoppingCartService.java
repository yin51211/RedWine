package com.wafersystems.cloud.orders.service;

import com.wafersystems.cloud.model.ShoppingCart;

import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
public interface IShoppingCartService {
    public Object saveShopingCart(ShoppingCart shoppingCart);

    public List<ShoppingCart> getAllCart();

    public int getProductQuantity();

    public Object deleteCart(ShoppingCart cart);

    public Object updateCart(ShoppingCart cart);

    public void deleteAll();

    public ShoppingCart getByProductID(Long productID);
}
