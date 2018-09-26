package com.globalmart.controller;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.globalmart.domain.Product;
import com.globalmart.service.ProductService;

public class ProductCatalogueControllerTest extends EasyMockSupport {

	private ProductCatalogueController productCatalogueController;
	private Product mockProduct;
	private ProductService mockProductService;
	private List<Product> products;

	@Before
	public void setUp() throws Exception {
		productCatalogueController = new ProductCatalogueController();
		mockProduct = createMock(Product.class);
		mockProductService = createMock(ProductService.class);
		products = new ArrayList<Product>();
		ReflectionTestUtils.setField(productCatalogueController, "productService", mockProductService);
	}

	@After
	public void tearDown() throws Exception {
		mockProduct = null;
		mockProductService = null;
		productCatalogueController = null;
		products = null;
	}

	@Test
	public void addProduct() {
		mockProductService.addProduct(mockProduct);
		replayAll();
		productCatalogueController.addProduct(mockProduct);
		verifyAll();
	}

	@Test
	public void deleteProduct() {
		mockProductService.deleteProduct(1);
		replayAll();
		productCatalogueController.deleteProduct(1);
		verifyAll();
	}

	@Test
	public void retrieveProductByType() {
		EasyMock.expect(mockProductService.retrieveProductByType("Shirt")).andReturn(products);
		replayAll();
		productCatalogueController.retrieveProductByType("Shirt");
		verifyAll();
	}

	@Test
	public void retrieveProducts() {
		EasyMock.expect(mockProductService.retrieveProducts()).andReturn(products);
		replayAll();
		productCatalogueController.retrieveProducts();
		verifyAll();
	}

	@Test
	public void retrieveProductPrice() {
		EasyMock.expect(mockProductService.retrievePrice(1)).andReturn(100.0);
		replayAll();
		productCatalogueController.retrieveProductPrice(1);
		verifyAll();
	}
}
