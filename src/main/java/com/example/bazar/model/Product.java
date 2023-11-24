package com.example.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long product_code;
    private String name;
    private String brand;
    private double cost;
    private double stock;
    @ManyToOne
    @JoinColumn(name = "sale_code")
    private Sale sale;

    public Product() {
    }

    public Product(Long product_code, String name, String brand, double cost, double stock, Sale sale) {
        this.product_code = product_code;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.stock = stock;
        this.sale = sale;
    }
    
}
