package com.example.apispringsecurity.Repository;


import com.example.apispringsecurity.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdRepository extends JpaRepository<Product, Long> {

}
