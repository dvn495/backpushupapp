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
@Table(name = "direccionpersona")
public class Direccionpersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_tipodireccion")
    private Tipodireccion tipoDireccion;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_persona")
    private Persona persona;
}
