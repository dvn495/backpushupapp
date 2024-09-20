package com.backpushup.backpushupapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tipomovcaja")
public class Tipomovcaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipomovcaja;

    private String tipo;
}
