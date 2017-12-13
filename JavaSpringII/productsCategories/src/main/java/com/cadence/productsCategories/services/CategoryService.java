package com.cadence.productsCategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cadence.productsCategories.models.CategoriesProducts;
import com.cadence.productsCategories.models.Category;
import com.cadence.productsCategories.models.Product;
import com.cadence.productsCategories.repositories.CategoriesProductsRepository;
import com.cadence.productsCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final CategoriesProductsRepository catProdRepository;
	
	public CategoryService(CategoryRepository categoryRepository, CategoriesProductsRepository catProdRepository) {
		this.categoryRepository = categoryRepository;
		this.catProdRepository = catProdRepository;
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category getCategory(Long id) {
		return categoryRepository.findOne(id);
	}
	
	public List<Category> availableCategories(Product product) {
		// As of right now, we do not know how to query single columns 
		// using the spring-data-jpa. I will create a list of name from the 
		// products and execute a not in query with the list in the CrudRepository
		List<String> names = new ArrayList<String>();
		List<Category> currentCats = product.getCategories();
		
		if(currentCats.isEmpty()) {
			// add empty string if there are not categories. Since an empty array does not have
			// a list of strings, we do not get any categories back;
			names.add("");	
		} else {
			for(Category c : currentCats) {
				names.add(c.getName());
			}	
		}
			
		List<Category> cats = categoryRepository.findByNameNotIn(names);
		return cats;
	}
	
	public void addCategory(CategoriesProducts catProd) {
		catProdRepository.save(catProd);
	}
	
	
}
