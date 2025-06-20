package com.lucas.web_services.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  @Column(name = "moment")
  private Instant moment;
  @Column(name = "orderStatus")
  private Integer orderStatus;
  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;

  @OneToMany(mappedBy = "id.order")
  private Set<OrderItem> items = new HashSet<>();

  public Order() {
  }

  public Order(Instant moment, OrderStatus orderStatus, User client) {
    this.moment = moment;
    setOrderStatus(orderStatus);
    this.client = client;
  }

  public Long getId() {
    return id;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public OrderStatus getOrderStatus() {
    return OrderStatus.valueOf(orderStatus);
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    if (orderStatus != null) {
      this.orderStatus = orderStatus.getCode();
    }
  }

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }

  public Set<OrderItem> getItems() {
    return items;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(id, order.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
