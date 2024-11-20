package com.java_Machine_Test.business_Application.service;

import com.java_Machine_Test.business_Application.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProduct();
    public Product getProductById(int id);
    public Product addProduct(Product product);
    public Product updateProduct(int id, Product product);
    public void deleteProduct(int id);
    public double getTotalRevenue();
    public double getRevenueByProduct(int productId);
}
