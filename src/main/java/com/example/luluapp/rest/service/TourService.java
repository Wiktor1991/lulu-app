package com.example.luluapp.rest.service;

import com.example.luluapp.rest.models.Tour;
import com.example.luluapp.rest.repositories.TourRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j

@Service
public class TourService {

    private final TourRepository orderRepository;

    public TourService(TourRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Tour tour){
        this.orderRepository.save(tour);
    }
    public Tour findById(Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    log.info("trying to get tour from database with given id [%d]".formatted (id));
                    return order;
                }).orElseThrow(()-> new RuntimeException("tour with given id [%d] not found ".formatted(id)));
    }

    public List<Tour> findAll() {
      return  orderRepository.findAll();
    }

    public List<Tour> saveAll(List<Tour> orders){
        return orderRepository.saveAll(orders);
    }
}
