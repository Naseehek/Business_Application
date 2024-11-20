package com.java_Machine_Test.business_Application.service;

import com.java_Machine_Test.business_Application.entity.Sale;

import java.util.List;

public interface SaleService {

    public Sale addSale(Sale sale);
    public List<Sale> getAllSales();
    public List<Sale> getSaleByProductId(int id);
}
