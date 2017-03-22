package com.wafersystems.cloud.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by weiguo.ren on 2016/3/1.
 */
@Entity
@Table(name = "users", catalog = "redwine", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Users implements Serializable {
    private Long id;
    private String name;
    private String password;
    private String email;
    private int state;
    private int level;
    private String  idCard;
    private String mobile;
    private String remark;
    private String reference;
    private long createTime;
    private String updateTime;
    private String userId;

    public Users(Long id, String name, String password, String email, int state, int level, String idCard, String mobile, String remark, String reference, long createTime, String updateTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.state = state;
        this.level = level;
        this.idCard = idCard;
        this.mobile = mobile;
        this.remark = remark;
        this.reference = reference;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Users() {
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
