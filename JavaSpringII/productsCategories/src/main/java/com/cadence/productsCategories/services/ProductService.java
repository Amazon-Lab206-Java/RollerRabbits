package com.cadence.productsCategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cadence.productsCategories.models.Category;
import com.cadence.productsCategories.models.Product;
import com.cadence.productsCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product getProduct(Long id) {
		return productRepository.findOne(id);
	}
	
	public List<Product> availableProducts(Category category) {
		// As of right now, we do not know how to query single columns 
		// using the spring-data-jpa. I will create a list of name from the 
		// products and execute a not in query with the list in the CrudRepository
		List<String> names = new ArrayList<String>();
		List<Product> currentProds = category.getProducts();
		
		if(currentProds.isEmpty()) {
			// add empty string if there are not categories. Since an empty array does not have
			// a list of strings, we do not get any categories back;
			names.add("");	
		} else {
			for(Product p : currentProds) {
				names.add(p.getName());
			}	
		}
			
		List<Product> prods = productRepository.findByNameNotIn(names);
		return prods;
	}
}
	