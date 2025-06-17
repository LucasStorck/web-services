package com.lucas.web_services.resources;

import com.lucas.web_services.model.Product;
import com.lucas.web_services.model.User;
import com.lucas.web_services.services.ProductService;
import com.lucas.web_services.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

  private final ProductService productService;

  public ProductResources(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    List<Product> productList = productService.findAll();
    return ResponseEntity.ok().body(productList);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    Product product = productService.findById(id);
    return ResponseEntity.ok().body(product);
  }
}
