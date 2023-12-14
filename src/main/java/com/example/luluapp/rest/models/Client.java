package com.example.luluapp.rest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long clientNumber;
    String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Bread> breadList;
}

