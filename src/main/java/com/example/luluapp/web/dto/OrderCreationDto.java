package com.example.luluapp.web.dto;

import com.example.luluapp.rest.models.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class OrderCreationDto {
    public List<Order> orderList = new ArrayList<>();

    public OrderCreationDto(List<Order> orders) {
    }

    public OrderCreationDto() {
    }

    public void addOrder(Order order ){
        this.orderList.add(order);
    }


}
