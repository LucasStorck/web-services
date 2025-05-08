package com.lucas.web_services.services;

import com.lucas.web_services.model.Order;
import com.lucas.web_services.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

  private final OrderRepository orderRepository;


  public OrderServices(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public Order findById(Long id) {
    Optional<Order> optionalOrder = orderRepository.findById(id);
    return optionalOrder.get();
  }
}
