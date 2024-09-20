package com.backpushup.backpushupapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import java.util.Date;
import lombok.Data;

@Entity
@Data
@Table(name = "historialpropiedad")
public class Historialpropiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_antiguedad")
    private Antiguedades antiguedad;
}
