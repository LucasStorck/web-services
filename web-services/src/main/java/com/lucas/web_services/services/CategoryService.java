package com.lucas.web_services.services;

import com.lucas.web_services.model.Category;
import com.lucas.web_services.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(Integer id) {
    Optional<Category> optionalCategory = categoryRepository.findById(id);
    return optionalCategory.get();
  }
}
