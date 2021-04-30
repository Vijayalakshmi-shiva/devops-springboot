package com.myapp.spring.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.myapp.spring.model.Product;
//import com.myapp.spring.repository.ProductRepository;
import com.myapp.spring.repository.Productrepository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
public class ProductRepositoryTest {
	

	
		@Autowired
		private Productrepository repository;
		
		private static File DATA_JSON= Paths.get("src","test","resources","products.json").toFile();
		
		@BeforeEach
		public void setup() throws JsonParseException, JsonMappingException, IOException {
		
		Product products []=new ObjectMapper().readValue(DATA_JSON,Product[].class);
		
		//save each product to database
		Arrays.stream(products).forEach(repository::save);
		}

	@AfterEach
	public void cleanUp() {
		repository.deleteAll();
	}

	@Test

	@DisplayName("Test product not found for a non existing id")
	public void testProductNotFoundForNonExistingId() {
		// given three products in the database
		
		Product product=repository.findById(100).orElseGet(()-> new Product());
		
		Assertions.assertNotNull(product.getProductid(), "Product With Id 100 should not exist");
	}
	@Test

	@DisplayName("Test product saved sucessfully")
	public void testProductSavedSucessfully() {
		// given a mock product
		Product product = new Product("Vivo", "VivoPro12", 40000.0, 4.8);
		product.setProductid(1);
		Product savedProduct=repository.save(product);
		
		Assertions.assertNotNull(savedProduct, "New Product should be saved");
		
		Assertions.assertNotNull(savedProduct.getProductid(), "New Product should have id");
		
		Assertions.assertEquals(product.getProductname(),savedProduct.getProductname());
	}
		
	@Test

	@DisplayName("Test product updated sucessfully")
	public void testProductUpdatedSucessfully() {
		// given a mock product
		Product product = new Product("OnePlus", "OnePlus9Pro", 70000.00, 4.5);
		product.setProductid(2); // 28 --> check with sqldatabase command  "select * from hibernate_sequence;"
		
		Product updatedProduct=repository.save(product);
		
		
		Assertions.assertEquals(product.getPrice(),updatedProduct.getPrice());
	}
		
	

	}
	


