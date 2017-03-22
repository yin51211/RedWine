package com.wafersystems.cloud.manage.service.impl;

import com.wafersystems.cloud.manage.model.IGoodsDao;
import com.wafersystems.cloud.manage.service.IGoodsService;
import com.wafersystems.cloud.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/27.
 */
@Service(value = "goodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Resource
    IGoodsDao goodsDao;
    @Autowired
    private ApplicationContext resource;

    @Override
    public Object saveGoods(Goods goods) {
        if (goods != null) {
            goodsDao.saveGoods(goods);
            return "su";
        }
        return null;
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getGoodsAll();
    }

    @Override
    public List<Goods> getGoodsByName(String name) {

        return goodsDao.getGoodByName(name);
    }

    @Override
    public Goods getGoodsById(Long id) {
        return goodsDao.getGoods(id);
    }
}
