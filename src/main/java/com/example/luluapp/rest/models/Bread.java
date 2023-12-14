package com.example.luluapp.rest.models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Bread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer articleNumber;
    private String picture;

    int[] orders;

}
