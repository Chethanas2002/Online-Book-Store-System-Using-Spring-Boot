package com.spring.OnlineBookStoreSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.Model.Category;
import com.spring.OnlineBookStoreSystem.Service.CategoryService;

@RestController
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/cat")
	public String greet() {
		return "Greet from category";
	}
	
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}
	
	@GetMapping("/categories")
	public List<Category> getAllCategories(){
		return categoryService.getAllCategory();
	}
	
	@GetMapping("/categories/id/{categoryId}")
	public Optional<Category> getCategoryById(@PathVariable int categoryId){
		return categoryService.getCategoryById(categoryId);
	}
	
	@GetMapping("/categories/name/{categoryName}")
	public Optional<Category> getCategoryByName(@PathVariable String categoryName){
		return categoryService.getCategoryByCategoryName(categoryName);
	}
	
	@GetMapping("/categories/partialname/{categoryName}")
	public List<Category> getCategoryByPartialName(@PathVariable String categoryName){
		return categoryService.getCategoryByPartialCategoryName(categoryName);
	}
	
	@DeleteMapping("/categories/{categoryId}")
	public String deleteCategoryById(@PathVariable int categoryId) {
		return categoryService.deleteCategoryById(categoryId);
	}

}
