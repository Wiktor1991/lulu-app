package com.example.luluapp.rest.service;

import com.example.luluapp.rest.models.OrderList;
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

    public void addOrder(OrderList orderList){
        this.orderRepository.save(orderList);
    }

    public List<OrderList> getAllOrders() {
        return  this.orderRepository.findAll();
    }

    public OrderList findById(Long id) {
        return orderRepository.findById(id)
                .map(orderList -> {
                    log.info(orderList.toString());
                    return orderList;

                }).orElseThrow(()-> new RuntimeException("order with given id [{id}] not found".formatted(id)));


    }

}
