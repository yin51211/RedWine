package com.wafersystems.cloud.manage.web;

import com.wafersystems.cloud.global.CloudPortalException;
import com.wafersystems.cloud.global.ReturnData;
import com.wafersystems.cloud.manage.service.IGoodsService;
import com.wafersystems.cloud.model.Goods;
import com.wafersystems.cloud.model.ShoppingCart;
import com.wafersystems.cloud.model.Users;
import com.wafersystems.cloud.orders.service.IShoppingCartService;
import com.wafersystems.cloud.reawine.service.IUsersService;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by weiguo.ren on 2016/3/24.
 */
@Controller
@RequestMapping("/caas/manage")
public class ManageContrller {

    private static final Logger LOGGER = Logger
            .getLogger(ManageContrller.class);

    @Autowired
    IUsersService usersService;
    @Autowired
    IGoodsService goodsService;
    @Autowired
    IShoppingCartService shoppingCartServic;

    @RequestMapping("/toCallIndex")
    @ResponseBody
    public ModelAndView toCallIndex(String token,
                                    @RequestParam(value = "imskey", required = false) String imskey,
                                    @RequestParam(value = "ims", required = false) String ims)
            throws Exception {
        Map<String, String> returnMap = new HashMap<String, String>();
        ModelAndView mv = new ModelAndView("manager/index", returnMap);
        return mv;
    }

    @RequestMapping("/toSmsIndex")
    @ResponseBody
    public ModelAndView toSmsIndex(String token) throws Exception {
        Map<String, String> returnMap = new HashMap<String, String>();
        ModelAndView mv = new ModelAndView("manager/smsIndex", returnMap);
        return mv;
    }

    @RequestMapping("/toGoods")
    @ResponseBody
    public ModelAndView toGoods(String token) throws Exception {
        Map<String, String> returnMap = new HashMap<String, String>();
        ModelAndView mv = new ModelAndView("manager/addGoods", returnMap);
        return mv;
    }

    @RequestMapping("/toShoppingCart")
    @ResponseBody
    public ModelAndView toShoppingCart(String token) throws Exception {
        Map<String, String> returnMap = new HashMap<String, String>();
        ModelAndView mv = new ModelAndView("orders/shoppingCart", returnMap);
        return mv;
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Object getUserInfo(HttpServletRequest request)
            throws Exception {
        String mobile = request.getSession().getAttribute("login_id").toString();
        Users users = usersService.getUserById(mobile);
        return ReturnData.getObjData(users);
    }

    @RequestMapping("/addGoods")
    @ResponseBody
    public ModelAndView addGoods(HttpServletRequest request, HttpServletResponse response, String pcName, String content,
                                 String price, int discount, String uploadFileRet) throws CloudPortalException {
        Goods goods = new Goods();
        goods.setName(pcName);
        goods.setContent(content);
        goods.setPrice(Double.parseDouble(price));
        goods.setDiscount(discount);
        goods.setImageUrl(uploadFileRet);
        goods.setUpdateTime((String.valueOf(new Date().getTime())));
        goods.setCreateTime(new Date().getTime());
        goodsService.saveGoods(goods);
        return new ModelAndView("manager/smsIndex");
    }

    @RequestMapping("/getAllGoods")
    @ResponseBody
    public Object getAllGoods(HttpServletRequest request)
            throws Exception {
        List<Goods> list = goodsService.getAllGoods();
        return ReturnData.getArrayData(list);
    }

    @RequestMapping("/getUpLoadFile")
    @ResponseBody
    public Object getUpLoadFile(HttpServletRequest request)
            throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        List<MultipartFile> uploadFiles = multipartRequest.getFiles("uploadFile");
        MultipartFile file = uploadFiles.get(0);
        String realPath = request.getSession().getServletContext().getRealPath("/resources/app");
        String fileName = new Date().getTime() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            File f1 = new File(realPath);
            if (!f1.exists()) {
                f1.mkdirs();
            }
            FileCopyUtils.copy(file.getBytes(), new File(realPath, fileName));
        } catch (IOException e) {
            return "fail";
        }
        return fileName;
    }

    @RequestMapping("/addShoppingCart")
    @ResponseBody
    public Object addShoppingCart(HttpServletRequest request, Long productID)
            throws Exception {
        Goods goods = goodsService.getGoodsById(productID);
        ShoppingCart shoppingCart = shoppingCartServic.getByProductID(productID);
        if (shoppingCart != null) {
            int quantity = shoppingCart.getQuantity() + 1;
            shoppingCart.setQuantity(quantity);
            shoppingCart.setSubTotal(String.valueOf(goods.getPrice() * quantity));
        } else {
            shoppingCart = new ShoppingCart();
            shoppingCart.setQuantity(1);
            shoppingCart.setProductID(goods.getId());
            shoppingCart.setProductName(goods.getName());
            shoppingCart.setDefaultImgUrl(goods.getImageUrl());
            shoppingCart.setPrice(String.valueOf(goods.getPrice()));
            shoppingCart.setSubTotal(String.valueOf(goods.getPrice()));
            shoppingCart.setCreateTime(new Date().getTime());
        }
        shoppingCartServic.saveShopingCart(shoppingCart);
        int size = shoppingCartServic.getProductQuantity();
        return size;
    }


}
