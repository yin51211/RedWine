package com.wafersystems.cloud.manage.model;

import com.wafersystems.cloud.model.Goods;

import java.util.List;

/**
 * Created by weiguo.ren on 2016/3/27.
 */
public interface IGoodsDao {

    public Goods getGoods(long id);
    public List<Goods> getGoodsAll();

    public List<Goods> getGoodByName(String name);

    public void  saveGoods(Goods goods);


}
