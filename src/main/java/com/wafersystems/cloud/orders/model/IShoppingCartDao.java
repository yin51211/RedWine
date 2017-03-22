package com.wafersystems.cloud.orders.model;

import com.wafersystems.cloud.model.ShoppingCart;

import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
public interface IShoppingCartDao {
    public void saveShoppingCart(ShoppingCart shoppingCart);

    public void deleteCart(ShoppingCart shoppingCart);

    public void updateCart(ShoppingCart shoppingCart);

    public void deleteAll();

    public List<ShoppingCart> getAllCart();

    public ShoppingCart getCartShoppingByProductID(Long productID);

    public int getProductQuantity();
}
