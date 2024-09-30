package com.example.parcial.entities;

import jakarta.persistence.*;
import lombok.*;
import com.example.inicial1.entities.Base;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Persona extends Base {

    @Column(name = "dna")
    private List<String> dna;

}
