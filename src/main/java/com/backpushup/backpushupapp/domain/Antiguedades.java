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
@Table(name="antiguedades")
public class Antiguedades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_antiguedad;

    private String nombre;

    @ManyToOne
    @Valid
    @JoinColumn(name="id_categoria")
    private Categorias categoria;

    @ManyToOne
    @Valid
    @JoinColumn(name="id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @Valid
    @JoinColumn(name="id_rankingantiguedad")
    private Rankingantiguedad rankingantiguedad;  

    @ManyToOne
    @Valid
    @JoinColumn(name="id_galeria")
    private Galeria galeria;

    @ManyToOne
    @Valid
    @JoinColumn(name="id_galeria")
    private Epocaantiguedad epocaantiguedad;

}
