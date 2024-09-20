package com.backpushup.backpushupapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import java.util.Date;
import lombok.Data;

@Entity
@Data
@Table(name = "despachos")
public class Despachos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha_despacho;
    private String direccion;

    @ManyToOne
    @Valid
    @JoinColumn(name = "id_transaccion")
    private Transacciones transaccion;
}
