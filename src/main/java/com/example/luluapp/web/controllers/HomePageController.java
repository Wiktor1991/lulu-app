package com.example.luluapp.web.controllers;


import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomePageController {
    public HomePageController(OrderService orderService) {
        this.orderService = orderService;
    }

    private final OrderService orderService;

    @GetMapping("/nav")
    public String home(){
        return "index";
    }
    @GetMapping("/")
    public String mainPage(Model model){

        List<Order> all = orderService.findAll();
        List<String> touren = all.stream().map(order -> order.getClient().getTour())
                .toList();


        model.addAttribute("toures", touren);
        return "tour";
    }
    @PostMapping("/sa")
    public String tur(@ModelAttribute String string){

        System.out.println("KURWA");
        System.out.println(string);

        return "redirect:/nav";

    }

}
