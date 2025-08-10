package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.Category;
import com.spring.OnlineBookStoreSystem.Repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> getAllCategory(){
		return categoryRepo.findAll();
	}
	
	public Optional<Category> getCategoryById(int id){
		return categoryRepo.findById(id);
	}
	
	public Optional<Category> getCategoryByCategoryName(String name){
		return categoryRepo.findByCategoryName(name);
	}
	
	
	public List<Category> getCategoryByPartialCategoryName(String name){
		return categoryRepo.findByCategoryNameContainingIgnoreCase(name);
	}
	
	
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public String deleteCategoryById(int id) {
		
		if(!categoryRepo.existsById(id)) {
			return "Category not found";
		}
		categoryRepo.deleteById(id);
		return "Category deleted successfully";
	}

}
