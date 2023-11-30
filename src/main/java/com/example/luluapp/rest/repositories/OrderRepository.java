package com.example.luluapp.rest.repositories;

import com.example.luluapp.rest.models.Order;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value ="update Order set orders= :orders where id= :id" )
    @Modifying
    @Transactional
    void updateOrderById(@Param("id") Long id,
                         @Param("orders") int[] orders);

}
