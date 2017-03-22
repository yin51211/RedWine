package com.wafersystems.cloud.common;

import com.wafersystems.cloud.global.CloudPortalException;
import com.wafersystems.cloud.global.GlobalConstant;
import com.wafersystems.cloud.global.ReturnData;
import com.wafersystems.cloud.model.Users;
import com.wafersystems.cloud.reawine.service.IUsersService;
import com.wafersystems.cloud.vo.ReturnMsg;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by weiguo.ren on 2016/3/2.
 */
@Controller
@RequestMapping("/init")
public class InitController {
    private static final Logger LOGGER = Logger.getLogger(InitController.class);

    @Autowired
    IUsersService usersService;

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request,HttpServletResponse response,
                              @RequestParam(required = false) String userId,
                              @RequestParam(required = false) String password)throws Exception{
        Map<String, String> mMap = new HashMap<String, String>();
        ModelAndView mv = null;
        if(StringUtils.isEmpty(userId)||StringUtils.isEmpty(password)){
            LOGGER.info("重新登录！");
            mMap.put("message", "重新登录");
            mv = new ModelAndView("index", mMap);
        }else{
            Users users=usersService.ckeckUser(userId,password, Locale.CHINESE);
            if(null!=users){
                request.getSession().setAttribute("login_id",
                        users.getMobile());
                mv = new ModelAndView("manager/index");
            }else{
                LOGGER.info("用户名或密码错误： 用户名：" + userId + " 密码：" + password);
                mMap.put("message", "用户名或密码错误");
                mv = new ModelAndView("index", mMap);
            }
        }

        return mv;
    }
    @RequestMapping("/regist")
    public ModelAndView regist(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ModelAndView mv = null;
        mv = new ModelAndView("manager/regist");
        return mv;
    }

    @RequestMapping("/initUser")
    @ResponseBody
    public ModelAndView initUser(String name,String password,String mobile,String remark,String reference,String email
            ,String idcard) throws CloudPortalException{

        Users users=new Users();
        users.setName(name);
        users.setPassword(password);
        users.setMobile(mobile);
        users.setEmail(email);
        users.setIdCard(idcard);
        users.setReference(reference);
        users.setRemark(remark);
        users.setLevel(0);
        users.setState(-1);
        users.setCreateTime(new Date().getTime());
        users.setUpdateTime(String.valueOf(new Date().getTime()));
        Users user= usersService.getUserById(mobile);
        Map<String, String> mMap = new HashMap<String, String>();
        ModelAndView mv = null;
        if(user==null) {
            usersService.saveUser(users);
            mv = new ModelAndView("index");
        }else{
            LOGGER.info("用户名或密码错误： 用户名：" + mobile + " 密码：" + password);
            mMap.put("message", "用户名重复");
            mv = new ModelAndView("manager/regist", mMap);
        }
        return mv;
    }

    /**
     * 管理员登出
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        Map<String, String> mMap = new HashMap<String, String>();
        ModelAndView mv = null;
        LOGGER.info("重新登录！");
        mMap.put("message", "重新登录");
        mv = new ModelAndView("index", mMap);
        return mv;
    }



}
