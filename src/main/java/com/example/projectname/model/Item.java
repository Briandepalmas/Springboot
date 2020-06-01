package com.example.projectname.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "items")
public class Item {


    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    private long id;


    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price")
    private Double itemPrice;

    @Column(name = "day_purchased")
    private String day;


    public Item() {
        super();
    }

    public Item(String itemName, Double itemPrice, String day) {
        super();
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.day=day;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


}

