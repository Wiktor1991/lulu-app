package com.example.luluapp.rest.restControllers;

import com.example.luluapp.rest.models.Order;
import com.example.luluapp.rest.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("orders/{id}")
    public ResponseEntity<?> updateById(@RequestBody int[] orders,
                                     @PathVariable Long id){
        return ResponseEntity.status(203)
                .body(orderService.updateListOf(id,orders));

    }


//    @PostMapping("orders/{id}")
//    public Order updateOrder(@PathVariable Long id,
//                             @RequestBody Order order){
//        return orderService.updateOrderById(order);
//    }
}
