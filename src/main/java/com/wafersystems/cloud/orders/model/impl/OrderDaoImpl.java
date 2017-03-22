package com.wafersystems.cloud.orders.model.impl;

import com.wafersystems.cloud.model.OrderInfo;
import com.wafersystems.cloud.orders.model.IOrderDao;
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
@Repository(value = "orderDao")
public class OrderDaoImpl implements IOrderDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sf;

    @Override
    public void saveOrder(OrderInfo orderInfo) {
        Session session = sf.getCurrentSession();
        session.save(orderInfo);

    }

    @Override
    public void updateOrder(OrderInfo orderInfo) {
        Session session = sf.getCurrentSession();
        session.update(orderInfo);
    }

    @Override
    public List<OrderInfo> getAllOrder() {
        Session session = sf.getCurrentSession();
        Query query=session.createQuery("from OrderInfo order by createTime desc");
        return query.list();
    }

    @Override
    public void deleteOrder(String orderNumber) {
        Session session = sf.getCurrentSession();
//        session.d
    }

    @Override
    public void updateOrderState(String orderNumber, int statusNumber) {
        Session session = sf.getCurrentSession();
        String sql="update OrderInfo set statusNumber:=statusNumber WHERE orderNumber=orderNumber";
        Query query = session.createSQLQuery(sql);
        query.setParameter("orderNumber",orderNumber);
        query.setParameter("statusNumber",statusNumber);
        query.executeUpdate();
    }
}
