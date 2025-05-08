package com.lucas.web_services.resources;

import com.lucas.web_services.model.Order;
import com.lucas.web_services.services.OrderServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

  private final OrderServices orderServices;

  public OrderResources(OrderServices orderServices) {
    this.orderServices = orderServices;
  }

  @GetMapping
  public ResponseEntity<List<Order>> findAll() {
    List<Order> orderList = orderServices.findAll();
    return ResponseEntity.ok().body(orderList);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Order> findById(@PathVariable Long id) {
    Order order = orderServices.findById(id);
    return ResponseEntity.ok().body(order);
  }
}
