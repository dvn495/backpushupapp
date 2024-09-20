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
@Table(name = "coleccionistas")
public class Coleccionistas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coleccionista;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_persona")
    private Persona persona;
}
