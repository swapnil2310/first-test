package com.globalmart.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * This Class is the Domain Class containing product details .
 */
@Entity
public class Product {

	@Id
	private int productId;
	private String productName;
	private String productType;
	private double productPrice;
	private String description;

	public Product() {

	}

	public Product(int productId, String productName, String productType, double productPrice, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
