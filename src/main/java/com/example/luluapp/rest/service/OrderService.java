package com.example.luluapp.rest.service;

import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order){
        this.orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return  this.orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    log.info(order.toString());
                    return order;

                }).orElseThrow(()-> new RuntimeException("order with given id [{id}] not found".formatted(id)));


    }

}
