package com.system.fridges.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "auto_order")
public class AutoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "date_delivery", nullable = false)
    private LocalDateTime dateDelivery;

    @Column(name = "number", nullable = false)
    private int number;

    @ManyToOne
    @Column(name = "access_order", nullable = false)
    @JoinColumn(name = "access_order")
    private Access  access;

    @ManyToOne
    @Column(name = "product_id", nullable = false)
    @JoinColumn(name = "product_id")
    private Product  product;

    public AutoOrder(LocalDateTime dateDelivery, int number, Access access, Product product) {
        this.dateDelivery = dateDelivery;
        this.number = number;
        this.access = access;
        this.product = product;
    }

    public AutoOrder() {}

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(LocalDateTime dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
