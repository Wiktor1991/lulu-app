package com.example.luluapp.web.controllers;

import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.service.OrderService;
import com.example.luluapp.web.dto.BreadCreationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ClientController {

    private final OrderService orderService;

    public ClientController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/clients")
    public String orders(@RequestParam String tourNumber, Model model){
        String client = "";

        List<Order> orders = orderService.findAll();
        List<Order> ordersByTour = new ArrayList<>();
        orders.stream().filter(order -> order.getClient().getTour().equals(tourNumber))
                .forEach(ordersByTour::add);

        model.addAttribute("clients", ordersByTour);
        model.addAttribute("tourNumber",tourNumber);
        model.addAttribute("client", client);
        return "clients";
    }

    @PostMapping("/clients")
    public String orders(@RequestParam String client, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("client", client);
        return "redirect:/orders";
    }

}
