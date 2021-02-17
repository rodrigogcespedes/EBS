package com.example.facturas.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "estados_facturas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EstadoFactura extends Base{

    @Column(name = "nombre_estado")
    private String nombreEstado;
}
