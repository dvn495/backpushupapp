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
@Table(name = "transacciones")
public class Transacciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_tipotransaccion")
    private Tipotransaccion tipoTransaccion;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_transaccionmediopago")
    private Transaccionmediopago transaccionMedioPago;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_estacionpago")
    private Estacionpago estacionPago;
}
