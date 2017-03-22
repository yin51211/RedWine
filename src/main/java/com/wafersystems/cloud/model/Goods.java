package com.wafersystems.cloud.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by weiguo.ren on 2016/3/1.
 */
@Entity
@Table(name = "goods", catalog = "redwine", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Goods implements Serializable {
    private Long id;
    private String name;
    private String content;
    private double price;
    private int discount;
    private String  imageUrl;
    private String mobile;
    private String remark;
    private String reference;
    private long createTime;
    private String updateTime;


    public Goods(Long id, String name, String content, double price, int discount, String imageUrl, String mobile, String remark, String reference, long createTime, String updateTime) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.price = price;
        this.discount = discount;
        this.imageUrl = imageUrl;
        this.mobile = mobile;
        this.remark = remark;
        this.reference = reference;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Goods() {
    }


    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "identity")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
