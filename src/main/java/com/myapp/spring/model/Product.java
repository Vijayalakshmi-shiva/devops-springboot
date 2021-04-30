package com.myapp.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "springboot_products")
public class Product {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private int productid;
	@Column(name = "PRODUCT_NAME",nullable = false)
	private String productname;
	@Column(name = "PRODUCT_DESCRIPTION")
	private String description;
	@Column(name = "PRODUCT_PRICE")
	private double price;
	@Column(name = "PRODUCT_STARRATING")
	private double starrating;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String productname, String description, double price, double starrating) {
		this.productname = productname;
		this.description = description;
		this.price = price;
		this.starrating = starrating;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getStarrating() {
		return starrating;
	}
	public void setStarrating(double starrating) {
		this.starrating = starrating;
	}
	

}
