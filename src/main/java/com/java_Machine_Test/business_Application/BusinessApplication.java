package com.java_Machine_Test.business_Application;

import com.java_Machine_Test.business_Application.entity.Product;
import com.java_Machine_Test.business_Application.entity.Sale;
import com.java_Machine_Test.business_Application.service.ProductService;
import com.java_Machine_Test.business_Application.service.SaleService;
import com.java_Machine_Test.business_Application.service.impl.ProductServiceImpl;
import com.java_Machine_Test.business_Application.service.impl.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BusinessApplication implements ApplicationRunner {

	@Autowired
	ProductService productService;
	@Autowired
	SaleService saleService;

	public static void main(String[] args) {

		SpringApplication.run(BusinessApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Product product1 = new Product("Product 1", "Description 1", 100.0, 10);
		Product product2 = new Product("Product 2", "Description 2", 200.0, 5);
		Product product3 = new Product("Product 3", "Description 3", 300.0,  20);

		productService.addProduct(product1);
		productService.addProduct(product2);
		productService.addProduct(product3);

		Sale sale1 = new Sale(2, LocalDate.now(), product1);
		Sale sale2 = new Sale(3, LocalDate.now(), product2);
		Sale sale3 = new Sale(1, LocalDate.now(), product3);

		saleService.addSale(sale1);
		saleService.addSale(sale2);
		saleService.addSale(sale3);
	}



	}



