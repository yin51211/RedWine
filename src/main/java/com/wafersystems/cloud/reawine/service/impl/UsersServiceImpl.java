package com.wafersystems.cloud.reawine.service.impl;

import com.wafersystems.cloud.global.CloudPortalException;
import com.wafersystems.cloud.model.Users;
import com.wafersystems.cloud.reawine.model.IUsersDao;
import com.wafersystems.cloud.reawine.service.IUsersService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

/**
 * Created by weiguo.ren on 2016/3/2.
 */
@Service(value = "usersService")
public class UsersServiceImpl implements IUsersService{
    private static final Logger LOGGER = Logger
            .getLogger(UsersServiceImpl.class);
    @Resource
    private IUsersDao userDao;
    @Autowired
    private ApplicationContext resource;

    @Override
    public Users ckeckUser(String userId, String password, Locale locale) throws CloudPortalException {
        if(StringUtils.isNotBlank(userId)&&StringUtils.isNotBlank(password)){
           return userDao.isUser(userId,password);
        }else {
            throw new CloudPortalException("用户名或密码错误");
        }
    }

    @Override
    public void loadUserFromAD(String userId, String mobile, String name, String mail) throws Exception {

    }

    @Override
    public List<Users> getUserByNameOrPinyin(String usernameOrPinyin, String mobile) {
        return null;
    }

    @Override
    public Users getUserById(String id) {
        Users users=  userDao.getUserById(id);
        return users;
    }

    @Override
    public List<Users> getAllUser() {
        return null;
    }

    @Override
    public Object saveUser(Users users) {

        if(users!=null){
            userDao.saveUsers(users);
            return "su";
        }
        return null;
    }
}
