package com.example.luluapp.rest.service;

import com.example.luluapp.rest.models.Bread;
import com.example.luluapp.rest.repositories.BreadRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BreadService {
    private final BreadRepository breadRepository;

    public BreadService(BreadRepository breadRepository) {
        this.breadRepository = breadRepository;
    }


    public void addBread(Bread bread){
        this.breadRepository.save(bread);
    }

    public List<Bread> getAllBreads() {
        return this.breadRepository.findAll();
    }

    public void saveAll(List<Bread> breads) {
        breadRepository.saveAll(breads);
    }

    public List<Bread> findAll() {
        return breadRepository.findAll();
    }
}
