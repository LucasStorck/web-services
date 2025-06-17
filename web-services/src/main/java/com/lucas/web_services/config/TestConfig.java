package com.lucas.web_services.config;

import com.lucas.web_services.model.*;
import com.lucas.web_services.repositories.CategoryRepository;
import com.lucas.web_services.repositories.OrderRepository;
import com.lucas.web_services.repositories.ProductRepository;
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

  private final UserRepository userRepository;
  private final OrderRepository orderRepository;
  private final CategoryRepository categoryRepository;
  public final ProductRepository productRepository;

  public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
    this.userRepository = userRepository;
    this.orderRepository = orderRepository;
    this.categoryRepository = categoryRepository;
    this.productRepository = productRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Category c1 = new Category(null, "Electronics");
    Category c2 = new Category(null, "Books");
    Category c3 = new Category(null, "Computers");

    Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
    Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
    Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
    Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

    categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    p1.getCategories().add(c2);
    p2.getCategories().add(c1);
    p3.getCategories().add(c3);
    p4.getCategories().add(c3);
    p5.getCategories().add(c2);

    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
    User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

    Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
    Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
    Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);


    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));

  }
}
