package com.wafersystems.cloud.orders.model.impl;

import com.wafersystems.cloud.model.ShoppingCart;
import com.wafersystems.cloud.orders.model.IShoppingCartDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
@SuppressWarnings("JpaQlInspection")
@Repository(value = "shoppingDao")
public class ShoppingDaoImpl implements IShoppingCartDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sf;

    @Override
    public void saveShoppingCart(ShoppingCart shoppingCart) {
        Session session = sf.getCurrentSession();
        session.save(shoppingCart);

    }

    @Override
    public void deleteCart(ShoppingCart shoppingCart) {
        Session session = sf.getCurrentSession();
        session.delete(shoppingCart);
    }

    @Override
    public void updateCart(ShoppingCart shoppingCart) {
        Session session = sf.getCurrentSession();
        session.update(shoppingCart);
    }

    @Override
    public void deleteAll() {
        Session session = sf.getCurrentSession();
        String sql="delete from ShoppingCart";
        Query query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public List<ShoppingCart> getAllCart() {
        Session session = sf.getCurrentSession();
        Query query=session.createQuery("from ShoppingCart order by createTime desc");
        return query.list();
    }

    @Override
    public ShoppingCart getCartShoppingByProductID(Long productID) {
        Session session = sf.getCurrentSession();
        Query query=session.createQuery("from ShoppingCart where productID=:productID");
        query.setParameter("productID",productID);
        List<ShoppingCart> list=query.list();
        return (list!=null&&!list.isEmpty())?list.get(0):null;
    }

    @Override
    public int getProductQuantity() {
        Session session = sf.getCurrentSession();
        Object  sum=session.createQuery("select sum(quantity) from ShoppingCart").uniqueResult();
        return sum!=null?Integer.parseInt(sum.toString()):0;
    }
}
