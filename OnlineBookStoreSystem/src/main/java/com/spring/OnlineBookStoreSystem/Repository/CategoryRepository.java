package com.spring.OnlineBookStoreSystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.OnlineBookStoreSystem.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
//	find category by name
	public Optional<Category> findByCategoryName(String categoryName);
	
//	find category by partial name
	public List<Category> findByCategoryNameContainingIgnoreCase(String categoryName);

}
