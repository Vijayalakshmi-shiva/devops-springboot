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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productid;
		result = prime * result + ((productname == null) ? 0 : productname.hashCode());
		temp = Double.doubleToLongBits(starrating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productid != other.productid)
			return false;
		if (productname == null) {
			if (other.productname != null)
				return false;
		} else if (!productname.equals(other.productname))
			return false;
		if (Double.doubleToLongBits(starrating) != Double.doubleToLongBits(other.starrating))
			return false;
		return true;
	}
	
	

}
