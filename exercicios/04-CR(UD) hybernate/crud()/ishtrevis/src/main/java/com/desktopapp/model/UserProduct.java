package com.desktopapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbUserProduct")
public class UserProduct{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user_product;
    private long id_user;
    private long id_product;
    private long quantity;

    public long getId() {
        return id_user_product;
    }
    public void setId(long id_user_product) {
        this.id_user_product = id_user_product;
    }
    public long getId_user() {
        return id_user;
    }
    public void setId_user(long id_user) {
        this.id_user = id_user;
    }
    public long getId_product() {
        return id_product;
    }
    public void setId_product(long id_product) {
        this.id_product = id_product;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    
}