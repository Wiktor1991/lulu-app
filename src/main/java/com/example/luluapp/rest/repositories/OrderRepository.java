package com.example.luluapp.rest.repositories;

import com.example.luluapp.rest.models.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderList, Long> {
}
