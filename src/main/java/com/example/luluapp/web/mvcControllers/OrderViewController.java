package com.example.luluapp.web.mvcControllers;
import com.example.luluapp.rest.models.Bread;
import com.example.luluapp.rest.service.OrderService;
import com.example.luluapp.web.dto.OrderCreationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



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
        orderService.findAll().iterator().forEachRemaining(orders::addOrder);

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

    @PostMapping("home")
    public String goToHomePage(){
        return "redirect:/home";
    }
}
