package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entitites.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        List<Order> orders = orderRepository.findAll();

        return orders;
    }

    public Order findById(int id) {
        Optional<Order> order = orderRepository.findById(id);

        return order.get();
    }
}
