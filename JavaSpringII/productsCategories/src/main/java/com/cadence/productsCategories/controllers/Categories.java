package com.cadence.productsCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cadence.productsCategories.models.CategoriesProducts;
import com.cadence.productsCategories.models.Category;
import com.cadence.productsCategories.services.CategoryService;
import com.cadence.productsCategories.services.ProductService;

@Controller
@RequestMapping("/categories")
public class Categories {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public Categories(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	

	@RequestMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			Category cat = categoryService.createCategory(category);
			String catId = Long.toString(cat.getId());
			return "redirect:/categories/".concat(catId);
		}
	}
	
	@RequestMapping("/{id}")
	public String showCategory(@ModelAttribute("catProd") CategoriesProducts catProd, @PathVariable("id") Long id, Model model) {
		Category category = categoryService.getCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.availableProducts(category));
		return "/categories/show.jsp";

	}

}

}
