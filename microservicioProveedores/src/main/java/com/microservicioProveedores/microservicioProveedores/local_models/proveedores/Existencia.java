package com.microservicioProveedores.microservicioProveedores.local_models.proveedores;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.microservicioProveedores.microservicioProveedores.local_models.Base;


@Entity
@Table(name = "existencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Audited
public class Existencia extends Base {
    @Column(name = "cantActual")
    private float cantActual;
    @Column(name = "cantEntrada")
    private float cantEntrada;


    @ManyToOne(cascade = CascadeType.MERGE)
    private Proveedor proveedor;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_Unidad")
    private Unidad expresadoEn;


}
