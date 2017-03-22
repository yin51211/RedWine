package com.wafersystems.cloud.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
@Entity
@Table(name = "shoppingCart", catalog = "redwine", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class ShoppingCart implements Serializable {

    private Long id;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "identity")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 商品ID
     */
    private Long productID;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品主图url地址
     */
    private String defaultImgUrl;

    /**
     *  会员购买价格
     *
     */
    private String price;

    /**
     * 市场价
     */
    private String marketPrice;

    /**
     * 购买数量
     */
    private int quantity;


    /**
     * 小计（价格）商品的单价*总数的价格
     */
    private String subTotal;

    /**
     * 创建时间
     */
    private long createTime;

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDefaultImgUrl() {
        return defaultImgUrl;
    }

    public void setDefaultImgUrl(String defaultImgUrl) {
        this.defaultImgUrl = defaultImgUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
