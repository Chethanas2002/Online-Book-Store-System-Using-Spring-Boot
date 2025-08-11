package com.spring.OnlineBookStoreSystem.DTO.CategoryDTO;

import lombok.Data;

@Data
public class CategoryResponseDTO {
	private int categoryId;
    private String categoryName;
    private String categoryDescription;
}
