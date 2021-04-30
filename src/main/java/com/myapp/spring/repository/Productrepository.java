package com.myapp.spring.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Product;

//Annotation is to identify that this is spring managed bean
//This is a data repository class

@Repository
public interface Productrepository extends JpaRepository<Product, Integer> {
		
	//select * from products where price
	Optional<List<Product>> findByPriceGreaterThanEqual(Double price);
	Optional<List<Product>> findByProductnameOrPrice(String productname,Double
			  price);

	
	/*
	 * Optional<List<Product>> findByProductnameOrPrice(String productname,Double
	 * price);
	 * 
	 * Optional<List<Product>> findByProductnameLike(String productname);
	 * 
	 * Optional<List<Product>> findByPriceIn(Collection<Double> prices);
	 * 
	 * Optional<List<Product>> findByProductnameIgnoreCase(String productname);
	 */
	 
}