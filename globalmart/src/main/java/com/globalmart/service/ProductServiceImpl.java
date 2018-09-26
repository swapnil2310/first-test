package com.globalmart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.domain.Product;
import com.globalmart.exception.GlobalmartException;
import com.globalmart.repository.ProductRepository;

/*
 * This Class processes all the requests and interacts with the in memory database. 
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> retrieveProducts() {
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(products::add);
		if (products.isEmpty()) {
			throw new GlobalmartException("No Products Found...!!!!!");
		}
		return products;
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.delete(id);
	}

	@Override
	public List<Product> retrieveProductByType(String productType) {
		List<Product> matchedProducts = searchProduct(productType);
		if (matchedProducts.isEmpty()) {
			throw new GlobalmartException("No Product matches the search criteria...!!!!!");
		}
		return matchedProducts;
	}

	private List<Product> searchProduct(String productType) {
		List<Product> matchedProducts = new ArrayList<Product>();
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(products::add);
		for (Product product : products) {
			if (product.getProductType().equalsIgnoreCase(productType)) {
				matchedProducts.add(product);
			}
		}
		return matchedProducts;
	}

	@Override
	public double retrievePrice(int id) {
		if (productRepository.findOne(id) != null) {
			return productRepository.findOne(id).getProductPrice();
		} else {
			throw new GlobalmartException("Product not found...!!!!!");
		}
	}

}
