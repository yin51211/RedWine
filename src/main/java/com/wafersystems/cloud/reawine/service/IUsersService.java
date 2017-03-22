package com.wafersystems.cloud.reawine.service;

import com.wafersystems.cloud.global.CloudPortalException;
import com.wafersystems.cloud.model.Users;

import java.util.List;
import java.util.Locale;

/**
 * Created by weiguo.ren on 2016/3/2.
 */
public interface IUsersService {

    public Users ckeckUser(String userId,String password,Locale locale)throws CloudPortalException;

    public void loadUserFromAD(String userId, String mobile, String name, String mail)
            throws Exception;

    public List<Users> getUserByNameOrPinyin(String userName, String mobile);

    public Users getUserById(String id);

    public List<Users> getAllUser();

    public Object saveUser(Users users);
}
