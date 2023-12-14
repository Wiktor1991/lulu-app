package com.example.luluapp.rest.restControllers;

import com.example.luluapp.rest.models.Tour;
import com.example.luluapp.rest.service.TourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class OrderRestController {

    private final TourService orderService;

    public OrderRestController(TourService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/orders")
    public List<Tour> getAllOrders(){
        return this.orderService.findAll();
    }
    @GetMapping("orders/{id}")
    public Tour getById(@PathVariable Long id ){
        return orderService.findById(id);
    }





}
