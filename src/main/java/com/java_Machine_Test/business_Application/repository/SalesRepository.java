package com.java_Machine_Test.business_Application.repository;

import com.java_Machine_Test.business_Application.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sale, Integer> {

    public List<Sale> findByProductId(int productId);
}
