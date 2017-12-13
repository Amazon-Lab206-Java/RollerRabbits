package com.cadence.productsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cadence.productsCategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category>findByNameNotIn(List<String>name);

}

