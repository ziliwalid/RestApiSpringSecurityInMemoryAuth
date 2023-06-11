package com.example.apispringsecurity.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String label;
    private String type;
    private float price;
}
