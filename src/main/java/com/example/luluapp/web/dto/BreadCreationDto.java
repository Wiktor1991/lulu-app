package com.example.luluapp.web.dto;

import com.example.luluapp.rest.models.Bread;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class BreadCreationDto {

    private List<Bread> breads = new ArrayList<>();

    public BreadCreationDto() {
    }

    public BreadCreationDto(List<Bread> breads) {
        this.breads = breads;
    }

    public void addBread(Bread bread){
        this.breads.add(bread);
    }
}
