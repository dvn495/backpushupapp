package com.backpushup.backpushupapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "rankingantiguedad")
public class Rankingantiguedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rankingantiguedad;

    private String nombre;

    private int puntuacion;
}

