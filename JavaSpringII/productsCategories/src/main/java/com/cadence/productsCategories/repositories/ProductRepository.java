package com.cadence.productsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cadence.productsCategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findByNameNotIn(List<String> name);

}
