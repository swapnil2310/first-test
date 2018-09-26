package com.globalmart.service;

import java.util.List;

import com.globalmart.domain.Product;

/*
 * This Interface contains methods that needs to be processed .
 */
public interface ProductService {

	void addProduct(Product product);

	List<Product> retrieveProducts();

	void deleteProduct(int id);

	List<Product> retrieveProductByType(String productType);

	double retrievePrice(int id);

}
