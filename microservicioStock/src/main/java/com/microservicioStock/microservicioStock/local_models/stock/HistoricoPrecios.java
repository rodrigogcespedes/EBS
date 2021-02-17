package com.microservicioStock.microservicioStock.local_models.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.microservicioStock.microservicioStock.local_models.Base;

import java.util.Date;


@Entity
@Table(name = "historicoPrecios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Audited
public class HistoricoPrecios extends Base {
    @Column(name = "fechaCambio")
    private Date fechaCambio;
    @Column(name = "precio")
    private float precio;


}
