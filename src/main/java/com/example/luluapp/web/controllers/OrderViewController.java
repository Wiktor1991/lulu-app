package com.example.luluapp.web.controllers;
import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.service.OrderService;
import com.example.luluapp.web.dto.OrderCreationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@Slf4j
public class OrderViewController {

    private final OrderService orderService;

    public OrderViewController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public String getOrders(Model model) {
        OrderCreationDto orders = new OrderCreationDto();
        orderService.findAll()
                .iterator()
                .forEachRemaining(orders::addOrder);

        //have to  add switch for specific clients

        OrderCreationDto edeka = new OrderCreationDto();

       orders.getOrderList().stream().filter(order -> order.getClient().getName().equals("Edeka"))
                       .forEach(order -> edeka.addOrder(order));

        model.addAttribute("orders", orders);
        return "orders";
    }

    @PostMapping("/update")
        public String update(@ModelAttribute OrderCreationDto orders){

        orders.getOrderList().stream().forEach(System.out::println);

        orders.getOrderList().forEach(order -> {
            orderService.addOrder(order);
        });
        return "redirect:/orders";

    }

    @GetMapping("home")
    public String goToHomePage(){
        return "redirect:/nav";
    }
}
