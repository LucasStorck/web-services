package com.lucas.web_services.config;

import com.lucas.web_services.model.Category;
import com.lucas.web_services.model.Order;
import com.lucas.web_services.model.OrderStatus;
import com.lucas.web_services.model.User;
import com.lucas.web_services.repositories.CategoryRepository;
import com.lucas.web_services.repositories.OrderRepository;
import com.lucas.web_services.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public void run(String... args) throws Exception {
    User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
    User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

    Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
    Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
    Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);

    Category c1 = new Category(null, "Electronics");
    Category c2 = new Category(null, "Books");
    Category c3 = new Category(null, "Computers");

    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
  }
}
