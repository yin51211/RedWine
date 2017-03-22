package com.wafersystems.cloud.reawine.model.impl;

import com.wafersystems.cloud.model.Users;
import com.wafersystems.cloud.reawine.model.IUsersDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/2.
 */
@SuppressWarnings("JpaQlInspection")
@Repository(value = "usersDao")
public class UsersDaoImpl implements IUsersDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sf;

    @Override
    public Users getUserByUserid(String username) {
        Session session=sf.getCurrentSession();
        Query query=session.createQuery("from Users where name=:name");
        query.setParameter("name",username);
        List<Users> list=query.list();
        if(list!=null&&!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void saveUsers(Users u) {
        Session session = sf.getCurrentSession();
        session.save(u);
    }

    @Override
    public List<Users> getUserByNameOrPinyin(String userName, String mobile) {
        Session session = sf.getCurrentSession();
        Query query=session.createQuery("from Users where name like:name or mobile like:mobile");
        query.setParameter("name","%"+userName+"%");
        query.setParameter("mobile","%"+mobile+"%");
        return query.list();
    }

    @Override
    public Users getUserById(String userId) {
        Session session=sf.getCurrentSession();
        Query query=session.createQuery("from Users where mobile=:mobile");
        query.setParameter("mobile",userId);
        List<Users> list=query.list();
        if(list!=null&&!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Users isUser(String username, String password) {
        Session session=sf.getCurrentSession();
        Query query=session.createQuery("from Users where mobile=:mobile and password=:password");
        query.setParameter("mobile",username);
        query.setParameter("password",password);
        List<Users> list=query.list();
        if(list!=null&&!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Users> getAllUser() {
        Session session = sf.getCurrentSession();
        Query query=session.createQuery("select id,name,password,email,state,level,idCard,mobile,remark,reference,createTime,updateTime from Users");
        return query.list();
    }

    @Override
    public List<Users> getUserByTime() {
        return null;
    }

    @Override
    public void UpdateUser(String name, int level) {
        Session session = sf.getCurrentSession();
        String sql = "update users set level=:level where mobile = :mobile";
        Query query = session.createSQLQuery(sql);
        query.setParameter("mobile", name);
        query.setParameter("level", level);
        query.executeUpdate();
    }
}
