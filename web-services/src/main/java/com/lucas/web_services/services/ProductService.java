package com.lucas.web_services.services;

import com.lucas.web_services.model.Product;
import com.lucas.web_services.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(Long id) {
    Optional<Product> obj = productRepository.findById(id);
    return obj.get();
  }
}
