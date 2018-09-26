package com.globalmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.domain.Product;
import com.globalmart.service.ProductService;

/*
 * This Class is the Rest Controller for this application
 */
@RestController
public class ProductCatalogueController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public List<Product> retrieveProducts() {
		return productService.retrieveProducts();

	}

	@RequestMapping("/products/{productType}")
	public List<Product> retrieveProductByType(@PathVariable String productType) {
		return productService.retrieveProductByType(productType);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public String addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return "Product added successfully..!!";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/products/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return "Product deleted successfully..!!";
	}

	@RequestMapping("/products/getPrice/{id}")
	public String retrieveProductPrice(@PathVariable int id) {
		return "Price of product  :" + productService.retrievePrice(id);

	}
}
