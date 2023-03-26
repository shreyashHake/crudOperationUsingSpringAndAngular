package com.project.springCrud.entity;

import javax.persistence.Table;

@Table(name = "customer")
public class Customer {
    private int customerId;
    private String customerName;
    private String customerAddres;
    private int mobile;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddres, int mobile) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddres = customerAddres;
        this.mobile = mobile;
    }

    
}
