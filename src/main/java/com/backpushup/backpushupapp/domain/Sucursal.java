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
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sucursal;

    private String nombre;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_ciudad")
    private Ciudades ciudad;
}
