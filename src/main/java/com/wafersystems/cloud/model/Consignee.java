package com.wafersystems.cloud.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
@Entity
@Table(name = "consignee", catalog = "redwine", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Consignee implements Serializable {
    private Long id;
    private String userId;
    private String receiver;//收货人
    /*
    *邮编
     */
    private String zIPCode;

    /*
     *地址
     */
    private String address;
    /*
    *手机
     */
    private String mobile;
    /*
    *电话
     */
    private String phone;
    /*
    *是否默认地址
     */
    private int isDefault;



    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "identity")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getzIPCode() {
        return zIPCode;
    }

    public void setzIPCode(String zIPCode) {
        this.zIPCode = zIPCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }
}
