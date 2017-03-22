package com.wafersystems.cloud.manage.service;

import com.wafersystems.cloud.model.Goods;

import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/27.
 */
public interface IGoodsService {
    public Object saveGoods(Goods goods);

    public List<Goods> getAllGoods();

    public List<Goods> getGoodsByName(String name);
    public Goods getGoodsById(Long id);
}
