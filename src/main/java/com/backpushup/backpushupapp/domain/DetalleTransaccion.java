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
@Table(name = "detalle_transaccion")
public class DetalleTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_transaccion;

    private Integer cantidad;
    private Double precio;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_antiguedad")
    private Antiguedades antiguedad;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_transaccion")
    private Transacciones transaccion;
}
