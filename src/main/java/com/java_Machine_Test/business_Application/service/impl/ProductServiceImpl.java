package com.java_Machine_Test.business_Application.service.impl;

import com.java_Machine_Test.business_Application.entity.Product;
import com.java_Machine_Test.business_Application.entity.Sale;
import com.java_Machine_Test.business_Application.exception.ProductNotFoundException;
import com.java_Machine_Test.business_Application.repository.ProductRepository;
import com.java_Machine_Test.business_Application.repository.SalesRepository;
import com.java_Machine_Test.business_Application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;

    public List<Product> getAllProduct() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts;
    }

    public Product getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("No product Found"));
        return product;
    }

    public Product addProduct(Product product) {
        Product addedProduct = productRepository.save(product);
        return addedProduct;
    }

    public Product updateProduct(int id, Product product) {
        Product p = getProductById(id);

        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setQuantity(product.getQuantity());

        return productRepository.save(p);
    }

    public void deleteProduct(int id) {

        productRepository.deleteById(id);
    }

    public double getTotalRevenue() {

        List<Sale> sales = salesRepository.findAll();

        double revenue = 0.0;

        for(Sale s : sales){
            revenue = revenue + s.getQuantity() * s.getProduct().getPrice();
        }

        return  revenue;
    }

    public double getRevenueByProduct(int productId) {
        Product prdct = getProductById(productId);

        double revenueByProduct = 0.0;

        for(Sale s : prdct.getSales()){
            revenueByProduct = revenueByProduct + s.getQuantity()*s.getProduct().getPrice();
        }

        return revenueByProduct;
    }


}
