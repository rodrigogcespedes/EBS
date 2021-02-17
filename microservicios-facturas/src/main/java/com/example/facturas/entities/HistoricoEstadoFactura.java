package com.example.facturas.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historico_estados_facturas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HistoricoEstadoFactura extends Base{

    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;

    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name="fk_estado_factura")
    private EstadoFactura estado;
}
