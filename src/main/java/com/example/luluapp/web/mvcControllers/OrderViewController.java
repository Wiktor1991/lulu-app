package com.example.luluapp.web.mvcControllers;
import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Controller
@Slf4j
public class OrderViewController {

    private final OrderService orderService;

    public OrderViewController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Order> orderList = orderService.getAllOrders();
        AtomicInteger sum = new AtomicInteger();

        orderList.forEach(order -> {
            sum.set(Arrays.stream(order.getOrders())
                    .sum());
        });
        model.addAttribute("orders", orderList);
        return "orders";
    }
    @PostMapping("home")
    public String goToHomePage(){
        return "redirect/home";
    }
}
