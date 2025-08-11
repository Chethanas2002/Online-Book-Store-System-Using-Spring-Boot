package com.spring.OnlineBookStoreSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.DTO.CategoryDTO.CategoryRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.CategoryDTO.CategoryResponseDTO;
import com.spring.OnlineBookStoreSystem.Service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        List<CategoryResponseDTO> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(categories); // HTTP 200
    }

    @GetMapping("/categories/id/{categoryId}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable int categoryId) {
        return categoryService.getCategoryById(categoryId)
                .map(ResponseEntity::ok)  // 200 OK + body
                .orElse(ResponseEntity.notFound().build());  // 404 Not Found if missing
    }

    @GetMapping("/categories/name/{categoryName}")
    public ResponseEntity<CategoryResponseDTO> getCategoryByName(@PathVariable String categoryName) {
        return categoryService.getCategoryByCategoryName(categoryName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categories/partialname/{categoryName}")
    public ResponseEntity<List<CategoryResponseDTO>> getCategoryByPartialName(@PathVariable String categoryName) {
        List<CategoryResponseDTO> categories = categoryService.getCategoryByPartialCategoryName(categoryName);
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content if empty list
        }
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseDTO> addCategory(@RequestBody CategoryRequestDTO categoryDTO) {
        CategoryResponseDTO savedCategory = categoryService.saveCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory); // 201 Created
    }

    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable int categoryId) {
        String result = categoryService.deleteCategoryById(categoryId);
        if (result.equals("Category not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result); // 200 OK
    }
}