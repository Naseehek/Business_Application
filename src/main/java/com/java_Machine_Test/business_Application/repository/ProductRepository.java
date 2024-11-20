package com.java_Machine_Test.business_Application.repository;

import com.java_Machine_Test.business_Application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
