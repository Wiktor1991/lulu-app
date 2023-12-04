package com.example.luluapp.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("orders")
    int[] orders ;


}
