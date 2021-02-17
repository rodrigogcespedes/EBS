package com.microservicioStock.microservicioStock.local_models.stock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.microservicioStock.microservicioStock.local_models.Base;


@Entity
@Table(name = "articulo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
public abstract class Articulo extends Base {
    @Column(name = "apilable")
    protected boolean apilable;
    @Column(name = "descripcion")
    protected String descripcion;
    @Column(name = "isComerciable")
    protected boolean isComerciable;
    @Column(name = "nombre")
    protected String nombre;
    @Column(name = "refrigerado")
    protected boolean refrigerado;
    @Column(name = "stockMax")
    protected int stockMax;
    @Column(name = "stockMin")
    protected int stockMin;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.microservicioStock.microservicioStock.local_models.stock.HistoricoPrecios> precio = new ArrayList<com.microservicioStock.microservicioStock.local_models.stock.HistoricoPrecios>();
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    private List<com.microservicioStock.microservicioStock.local_models.stock.Articulos_Existencia> articulos_existencias= new ArrayList<>();
}
