package com.educandoweb.course.repositories;

import com.educandoweb.course.entitites.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
