package com.lucas.web_services.resources;

import com.lucas.web_services.model.Category;
import com.lucas.web_services.services.CategoryService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  private final CategoryService categoryService;

  public CategoryResource(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    List<Category> categoryList = categoryService.findAll();
    return ResponseEntity.ok().body(categoryList);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> findById(@PathVariable Integer id) {
    Category category = categoryService.findById(id);
    return ResponseEntity.ok().body(category);
  }
}
