package com.example.luluapp.rest.service;

import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Arrays;
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
                    log.info("trying to get order from database with given id [%d]".formatted (id));
                    return order;
                }).orElseThrow(()-> new RuntimeException("order with given id [%d] not found ".formatted(id)));
    }
    public Order updateOrderById(Order order) {
        Order byId = findById(order.getId());
        orderRepository.save(order);
        return byId;
    }

    public Order updateListOf(Long id ,int[] orders){
        log.info("trying to update orders for Order with [%d] id".formatted(id));
        orderRepository.updateOrderById(id,orders);
         orderRepository.findById(id).map(order -> {
             log.info("Order with [%d] id  updated !".formatted(id));
             return order;
         }).orElseThrow(()-> new RuntimeException("Error! Order with given id does not exist!  "));
         return null;
    }

    public List<Order> findAll() {
      return  orderRepository.findAll();
    }

    public List<Order> saveAll(List<Order> orders){
        return orderRepository.saveAll(orders);
    }
}
