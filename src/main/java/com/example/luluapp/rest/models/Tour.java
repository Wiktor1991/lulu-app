package com.example.luluapp.rest.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TOUR")
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String tourNumber;
    @OneToMany(fetch = FetchType.EAGER)
    List<Client> clients;

}
