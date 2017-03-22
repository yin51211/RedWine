package com.wafersystems.cloud.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by weiguo.ren on 2016/3/29.
 */
@Entity
@Table(name = "product", catalog = "redwine", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Product  implements Serializable {
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
     *订单号
     */
    private OrderInfo orderNumber;
    /**
     *商品Id
     */
    private long productId;
    /**
     *商品名称
     */
    private String productName;
    /**
     *商品单价
     */
    private String productPrice;
    /**
     *商品数量
     */
    private int quantity;
    /**
     *商品总价
     */
    private String subTotal;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public OrderInfo getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(OrderInfo orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
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
}
