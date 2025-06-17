package com.lucas.web_services.repositories;

import com.lucas.web_services.model.Category;
import com.lucas.web_services.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
