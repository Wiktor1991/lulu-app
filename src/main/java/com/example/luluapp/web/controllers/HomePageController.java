package com.example.luluapp.web.controllers;


import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
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
        String string ="";
        List<Order> all = orderService.findAll();
        List<String> touren = all.stream().map(order -> order.getClient().getTour())
                .toList();
        model.addAttribute("toures", touren);
        model.addAttribute("tourNumber",string);
        return "tour";
    }
    @PostMapping("/tour")
    public String tur(@RequestParam String tor, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("tourNumber", tor);
        log.info("data : " + tor);
        return "redirect:/clients";
    }
}
