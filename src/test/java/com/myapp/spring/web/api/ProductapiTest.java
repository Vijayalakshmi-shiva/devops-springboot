package com.myapp.spring.web.api;


import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.Product;
//import com.myapp.spring.repository.ProductRepository;
import com.myapp.spring.repository.Productrepository;


@SpringBootTest

@AutoConfigureMockMvc
public class ProductapiTest {
	
	@MockBean
	private Productrepository repository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test

	@DisplayName("Test Product by ID - GET /api/v1/products/")
	public void testGetProductsById() throws Exception {
		
		// Prepare Mock Service Method
		
		Product product = new Product("OnePlus", "OnePlus9Pro", 70000.00, 4.5);
		product.setProductid(5);
		
		//prepare Mock service Method
		
		doReturn(Optional.of(product)).when(repository).findById(product.getProductid());
		//.orElseGet(()-> new Product());
		
		// Perform GET request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/{id}",5))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$.productid" , is(5)))
		.andExpect(jsonPath("$.productname" , is("OnePlus")))
		.andExpect(jsonPath("$.description" , is("OnePlus9Pro")))
		.andExpect(jsonPath("$.price" , is(70000.0)))
		.andExpect(jsonPath("$.starrating" , is(4.5)));
		
		
		
		
	}  
	
	
	  @Test
	  
	  @DisplayName("Test All Products /api/v1/products/") public void
	  testGetAllProducts() throws Exception {
	  
	  // Prepare Mock Service Method
	  
	  Product product1 = new Product("OnePlus", "OnePlus9Pro", 70000.00, 4.5);
	  product1.setProductid(2);
	  
	  Product product2 = new Product("OnePlus", "OnePlus8Pro", 60000.00, 4.5);
	  product2.setProductid(4);
	  
	  List<Product>products = new ArrayList<>(); products.add(product1);
	  products.add(product2);
	  
	  //prepare Mock service Method
	  
	  doReturn(products).when(repository).findAll();
	  
	  // Perform GET request
	  
	  mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")) // Validat Status should be 200 OK and JSON response received
	  .andExpect(status().isOk())
	  .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	  
	  // Validate Response Body
	  
	  .andExpect(jsonPath("$[0].productid" , is(2)))
	  .andExpect(jsonPath("$[0].productname" , is("OnePlus")))
	  .andExpect(jsonPath("$[0].description" , is("OnePlus9Pro")))
	  .andExpect(jsonPath("$[0].price" , is(70000.00)))
	  .andExpect(jsonPath("$[0].starrating" , is(4.5)))
	  
	  .andExpect(jsonPath("$[1].productid" , is(4)))
	  .andExpect(jsonPath("$[1].productname" , is("OnePlus")))
	  .andExpect(jsonPath("$[1].description" , is("OnePlus8Pro")))
	  .andExpect(jsonPath("$[1].price" , is(60000.00)))
	  .andExpect(jsonPath("$[1].starrating" , is(4.5)));
	  
	  
	  
	  }
	  
		
		  @Test
		  
		  @DisplayName("Test Add New Product  /api/v1/products/") public void testAddNewProduct() throws
		  Exception {
		  
		  // Prepare Mock Service Method
		  
		  Product newproduct = new Product("Vivo", "VivoPro12", 40000.00, 4.8);
		  
		  Product mockproduct = new Product("Vivo", "VivoPro12", 40000.00, 4.8);
		  mockproduct.setProductid(50);
		  
		  //prepare Mock service Method
		  
		  doReturn(mockproduct).when(repository).save(ArgumentMatchers.any());
		  
		  
		  // Perform POST request
		  
		  mockMvc.perform(post("/api/v1/products/finds") // Validate Status should be 200 OKand JSON response received
		  
		  .contentType(MediaType.APPLICATION_JSON_VALUE) .content(new
		  ObjectMapper().writeValueAsString(newproduct))) // Validate Response Body
		  
		  .andExpect(status().isCreated())
		  .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		  .andExpect(jsonPath("$.productid" , is(50)))
		  .andExpect(jsonPath("$.productname" , is("Vivo")))
		  .andExpect(jsonPath("$.description" , is("VivoPro12")))
		  .andExpect(jsonPath("$.price" , is(40000.0)))
		  .andExpect(jsonPath("$.starrating" , is(4.8)));
		  
		  
		  
		  
		  }
		  
		  
		 
	 @Test
	  @DisplayName("Test All Products by price /api/v1/products/find/{price}") public void
	  testGetAllProductsbyPrice() throws Exception {
	  
	  // Prepare Mock Service Method
	  
	  Product product1 = new Product("OnePlus", "OnePlus9Pro", 70000.00, 4.5);
	  product1.setProductid(5);
	  
	  Product product2 = new Product("OnePlus", "OnePlus8Pro", 60000.00, 4.5);
	  product2.setProductid(4);
	  Product product3 = new Product("OnePlus", "OnePlus6Pro", 50000.00, 4.5);
	  product1.setProductid(2);
	  
	  
	  
	  List<Product>products = new ArrayList<>(); 
	  products.add(product1);
	  products.add(product2);
	  products.add(product3);
	  
	  double price = 50000;
	  //prepare Mock service Method
	  
	  doReturn(Optional.of(products)).when(repository).findByPriceGreaterThanEqual(price);
	  
	  // Perform GET request
	  
	  mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/find/{price}",price)) // Validate Status should be 200 OK and JSON response received
	  .andExpect(status().isOk())
	  .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	  
	  // Validate Response Body
	  
	  .andExpect(jsonPath("$[0].productid" , is(2)))
	  .andExpect(jsonPath("$[0].productname" , is("OnePlus")))
	  .andExpect(jsonPath("$[0].description" , is("OnePlus9Pro")))
	  .andExpect(jsonPath("$[0].price" , is(70000.00)))
	  .andExpect(jsonPath("$[0].starrating" , is(4.5)))
	  
	  .andExpect(jsonPath("$[1].productid" , is(4)))
	  .andExpect(jsonPath("$[1].productname" , is("OnePlus")))
	  .andExpect(jsonPath("$[1].description" , is("OnePlus8Pro")))
	  .andExpect(jsonPath("$[1].price" , is(60000.00)))
	  .andExpect(jsonPath("$[1].starrating" , is(4.5)))
	 
	  .andExpect(jsonPath("$[2].productid" , is(0)))
	  .andExpect(jsonPath("$[2].productname" , is("OnePlus")))
	  .andExpect(jsonPath("$[2].description" , is("OnePlus6Pro")))
	  .andExpect(jsonPath("$[2].price" , is(50000.00)))
	  .andExpect(jsonPath("$[2].starrating" , is(4.5)));
	  
	  
	  
	  }
	  
	  
	 
	
	

}