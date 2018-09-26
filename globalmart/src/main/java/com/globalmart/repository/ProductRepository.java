package com.globalmart.repository;

import org.springframework.data.repository.CrudRepository;
import com.globalmart.domain.Product;

/*
 * This Interface  is the Repository implementation .
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
