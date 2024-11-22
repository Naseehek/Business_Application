package com.java_Machine_Test.business_Application.controller;

import com.java_Machine_Test.business_Application.entity.Sale;
import com.java_Machine_Test.business_Application.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    @Operation(summary = "Add a new sale")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
        Sale savedSale = saleService.addSale(sale);
        return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all sales")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/product/{productId}")
    @Operation(summary = "Het sales for products by id")
    public List<Sale> getSalesByProductId(@PathVariable int productId) {
        return saleService.getSaleByProductId(productId);
    }
}
