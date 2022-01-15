package com.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderPrice;
    private String orderAddress;
    private String orderDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderModel(Long id, String orderPrice, String orderAddress, String orderDate) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.orderAddress = orderAddress;
        this.orderDate = orderDate;
    }

    public OrderModel() {
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}
