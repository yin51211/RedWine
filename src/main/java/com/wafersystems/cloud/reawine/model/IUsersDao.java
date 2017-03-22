package com.wafersystems.cloud.reawine.model;

import com.wafersystems.cloud.model.Users;

import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/2.
 */
public interface IUsersDao {
    public Users getUserByUserid(String username);

    public void saveUsers(Users u);

    public List<Users> getUserByNameOrPinyin(String userName, String mobile);

    public Users getUserById(String userId);
    public Users isUser(String userId,String password);

    public List<Users> getAllUser();

    public List<Users> getUserByTime();

    public void UpdateUser(String name,int level);

}
