package com.example.luluapp.web.dto;

import com.example.luluapp.rest.models.Bread;
import com.example.luluapp.rest.models.Tour;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class OrderCreationDto {
    public List<Bread> breads = new ArrayList<>();

    public OrderCreationDto(List<Bread> orders) {
    }

    public OrderCreationDto() {
    }

    public void addBread(Bread bread){
        this.breads.add(bread);
    }
}
