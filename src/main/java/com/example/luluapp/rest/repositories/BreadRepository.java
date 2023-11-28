package com.example.luluapp.rest.repositories;

import com.example.luluapp.rest.models.Bread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreadRepository extends JpaRepository<Bread,Long> {
}
