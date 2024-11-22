package com.java_Machine_Test.business_Application.controller;

import com.java_Machine_Test.business_Application.entity.Product;
import com.java_Machine_Test.business_Application.exception.InvalidRequestException;
import com.java_Machine_Test.business_Application.service.ProductService;
import com.java_Machine_Test.business_Application.util.PdfGenerator;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    @Operation(summary = "Get all products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by Id")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.FOUND);
    }

    @PostMapping
    @Operation(summary = "Add a new product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        if(product.getName() == null || product.getPrice()<=0){
            throw new InvalidRequestException("Product name is required and price should be larger than zero ");
        }

        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Add a new product")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Add a new product")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/revenue")
    @Operation(summary = "Calculates the total Revenue")
    public ResponseEntity<Double> getTotalRevenue() {
        return new ResponseEntity<>(productService.getTotalRevenue(), HttpStatus.OK);
    }

    @GetMapping("/{id}/revenue")
    @Operation(summary = "Calculate the revenue for each product")
    public ResponseEntity<Double> getRevenueByProduct(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getRevenueByProduct(id), HttpStatus.OK);
    }

    @GetMapping("/downloadPdf")
    @Operation(summary = "Get the Product list as PDF")
    public ResponseEntity<byte[]> downloadProductTableAsPdf(){
        List<Product> prdcts = productService.getAllProduct();
        byte[] pdfBytes = PdfGenerator.productTablePdf(prdcts);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=products.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

    }
}
