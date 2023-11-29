package com.example.luluapp.rest.restControllers;

import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return this.orderService.getAllOrders();
    }
    @GetMapping("orders/{id}")
    public Order getById(@PathVariable Long id ){
        return orderService.findById(id);


    }
}
