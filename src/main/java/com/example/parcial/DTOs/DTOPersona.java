package com.example.parcial.DTOs;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DTOPersona {

    private List<String> dna;
    private boolean mutant;

}
