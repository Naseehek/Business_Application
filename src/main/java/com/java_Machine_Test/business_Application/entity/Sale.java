package com.java_Machine_Test.business_Application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private LocalDate saleDate;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public Sale(int quantity, LocalDate saleDate, Product product) {
        this.quantity = quantity;
        this.saleDate = saleDate;
        this.product = product;
    }
}
