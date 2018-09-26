package com.globalmart.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.globalmart.domain.Product;
import com.globalmart.repository.ProductRepository;

public class ProductServiceImplTest extends EasyMockSupport {
	private ProductServiceImpl productServiceImpl;
	private Product mockProduct;
	private List<Product> products;
	private ProductRepository mockProductRepository;

	@Before
	public void setUp() throws Exception {
		productServiceImpl = new ProductServiceImpl();
		mockProduct = createMock(Product.class);
		mockProductRepository = createMock(ProductRepository.class);
		products = new ArrayList<Product>();
		ReflectionTestUtils.setField(productServiceImpl, "productRepository", mockProductRepository);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addProduct() {
		EasyMock.expect(mockProductRepository.save(mockProduct)).andReturn(mockProduct);
		replayAll();
		productServiceImpl.addProduct(mockProduct);
		verifyAll();
	}

	@Test
	public void deleteProduct() {
		mockProductRepository.delete(1);
		replayAll();
		productServiceImpl.deleteProduct(1);
		verifyAll();
	}

	@Test
	public void retrievePrice() {
		EasyMock.expect(mockProductRepository.findOne(1)).andReturn(mockProduct).times(2);
		EasyMock.expect(mockProduct.getProductPrice()).andReturn(100.0);
		replayAll();
		productServiceImpl.retrievePrice(1);
		verifyAll();
	}

}
