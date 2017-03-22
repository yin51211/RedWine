package com.wafersystems.cloud.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
@Entity
@Table(name = "order", catalog = "redwine", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class OrderInfo implements Serializable {
    private Long id;
    /*
    *订单ID
     */
    private String orderNumber;
    /*
    *用户Id
     */
    private String userId;
    /**
     * 运费ID
     */
    private int FeeID;
    /**
     * 发票标题
     */
    private String InvoiceTitle;
    /**
     * 付款方式
     */
    private int PaymentID;
    /**
     * 备注
     */
    private String Description;
    /**
     * 收货人
     */
    private int ReceiverID;
    /**
     * 订单状态
     */
    private int statusNumber;
    /**
     * 订单总价
     */
    private double Payment;
    /**
     * 修改时间
     */
    private long updateTime;
    /**
     * 创建时间
     */
    private long createTime;

    private Set<Product> product;


    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "identity")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getFeeID() {
        return FeeID;
    }

    public void setFeeID(int feeID) {
        FeeID = feeID;
    }

    public String getInvoiceTitle() {
        return InvoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        InvoiceTitle = invoiceTitle;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int paymentID) {
        PaymentID = paymentID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getReceiverID() {
        return ReceiverID;
    }

    public void setReceiverID(int receiverID) {
        ReceiverID = receiverID;
    }

    public int getStatusNumber() {
        return statusNumber;
    }

    public void setStatusNumber(int statusNumber) {
        this.statusNumber = statusNumber;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public double getPayment() {
        return Payment;
    }

    public void setPayment(double payment) {
        Payment = payment;
    }
//    @OneToMany(mappedBy = "orderNumber",cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)

    @OneToMany(mappedBy = "orderNumber", targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set getProduct() {
        return product;
    }

    public void setProduct(Set product) {
        this.product = product;
    }
}
