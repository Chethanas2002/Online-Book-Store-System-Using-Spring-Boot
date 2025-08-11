package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.DTO.CategoryDTO.CategoryRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.CategoryDTO.CategoryResponseDTO;
import com.spring.OnlineBookStoreSystem.Model.Category;
import com.spring.OnlineBookStoreSystem.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public List<CategoryResponseDTO> getAllCategory() {
        return categoryRepo.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public Optional<CategoryResponseDTO> getCategoryById(int id) {
        return categoryRepo.findById(id).map(this::mapToResponseDTO);
    }

    public Optional<CategoryResponseDTO> getCategoryByCategoryName(String name) {
        return categoryRepo.findByCategoryName(name).map(this::mapToResponseDTO);
    }

    public List<CategoryResponseDTO> getCategoryByPartialCategoryName(String name) {
        return categoryRepo.findByCategoryNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public CategoryResponseDTO saveCategory(CategoryRequestDTO dto) {
        Category category = mapToEntity(dto);
        Category savedCategory = categoryRepo.save(category);
        return mapToResponseDTO(savedCategory);
    }

    public String deleteCategoryById(int id) {
        if (!categoryRepo.existsById(id)) {
            return "Category not found";
        }
        categoryRepo.deleteById(id);
        return "Category deleted successfully";
    }

    // Helper: Entity → ResponseDTO
    private CategoryResponseDTO mapToResponseDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setCategoryDescription(category.getCategoryDescription());
        return dto;
    }

    // Helper: RequestDTO → Entity
    private Category mapToEntity(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        category.setCategoryDescription(dto.getCategoryDescription());
        return category;
    }
}
