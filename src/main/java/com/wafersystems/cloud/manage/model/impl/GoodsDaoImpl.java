package com.wafersystems.cloud.manage.model.impl;

import com.wafersystems.cloud.manage.model.IGoodsDao;
import com.wafersystems.cloud.model.Goods;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/27.
 */
@SuppressWarnings("JpaQlInspection")
@Repository(value = "goodsDao")
public class GoodsDaoImpl implements IGoodsDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sf;

    @Override
    public Goods getGoods(long id) {
        Session session = sf.getCurrentSession();
        Query query=session.createQuery("from Goods where id=:id");
        query.setParameter("id",id);
        List<Goods> list=query.list();
        return (list==null||list.isEmpty())?null:list.get(0);
    }

    @Override
    public List<Goods> getGoodsAll() {
        Session session = sf.getCurrentSession();
        Query query=session.createQuery("select id,name,content,price,discount,imageUrl,mobile,remark,reference,createTime,updateTime from Goods");
        return query.list();
    }

    @Override
    public List<Goods> getGoodByName(String name) {
        Session session = sf.getCurrentSession();
        Query query=session.createQuery("from Goods where name=:name");
        query.setParameter("name",name);
        return query.list();
    }

    @Override
    public void saveGoods(Goods goods) {
        Session session = sf.getCurrentSession();
        session.save(goods);
    }
}
