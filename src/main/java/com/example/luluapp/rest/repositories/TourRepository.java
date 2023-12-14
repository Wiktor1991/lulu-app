package com.example.luluapp.rest.repositories;

import com.example.luluapp.rest.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {


}
