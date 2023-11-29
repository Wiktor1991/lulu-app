package com.example.luluapp.rest.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
@Data

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    Client client;
    @ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.MERGE)
    Bread bread;
    int[] orders ;
}
