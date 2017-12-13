package com.cadence.productsCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadence.productsCategories.models.CategoriesProducts;

@Repository
public interface CategoriesProductsRepository extends CrudRepository<CategoriesProducts, Long> {

}
