package com.example.luluapp.web.controllers;
import com.example.luluapp.rest.service.OrderService;
import com.example.luluapp.web.dto.OrderCreationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@Slf4j
public class OrderViewController {

    private final OrderService orderService;

    public OrderViewController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public String getOrders(Model model, @RequestParam String client) {

        OrderCreationDto orders = new OrderCreationDto();
        orderService.findAll().stream().filter(order -> order.getClient().getName().equals(client))
                        .iterator()
                                .forEachRemaining(orders::addOrder);
        model.addAttribute("orders", orders);
        model.addAttribute("client", client);
        return "orders";
    }

    @PostMapping("/update")
        public String update(@ModelAttribute OrderCreationDto orders, RedirectAttributes redirectAttributes){
        String client =
        orders.orderList.stream().findFirst().map(order -> order.getClient().getName()).orElse("");

        redirectAttributes.addAttribute("client", client);

        orders.getOrderList().forEach(orderService::addOrder);
        return "redirect:/orders";

    }

    @GetMapping("home")
    public String goToHomePage(){
        return "redirect:/nav";
    }
}
