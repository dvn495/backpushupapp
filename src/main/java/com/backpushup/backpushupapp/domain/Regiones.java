package com.backpushup.backpushupapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Data;

@Entity
@Data
@Table(name = "regiones")
public class Regiones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_region;

    private String nombre;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_pais")
    private Paises pais;
}
