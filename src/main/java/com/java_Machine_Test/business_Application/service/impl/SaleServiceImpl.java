package com.java_Machine_Test.business_Application.service.impl;

import com.java_Machine_Test.business_Application.entity.Product;
import com.java_Machine_Test.business_Application.entity.Sale;
import com.java_Machine_Test.business_Application.repository.SalesRepository;
import com.java_Machine_Test.business_Application.service.ProductService;
import com.java_Machine_Test.business_Application.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    ProductService productService;

    @Transactional
    public Sale addSale(Sale sale) {
        Product product = productService.getProductById(sale.getProduct().getId());

        product.setQuantity(product.getQuantity()- sale.getQuantity());

        Sale saved = salesRepository.save(sale);

        return saved;
    }

    public List<Sale> getAllSales() {
        return salesRepository.findAll();
    }

    public List<Sale> getSaleByProductId(int id) {
        return salesRepository.findByProductId(id);
    }
}
