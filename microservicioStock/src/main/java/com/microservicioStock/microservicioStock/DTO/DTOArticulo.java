package com.microservicioStock.microservicioStock.DTO;

import java.util.ArrayList;
import java.util.List;

import com.microservicioStock.microservicioStock.local_models.stock.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class DTOArticulo extends BaseDTO<Articulo> {

    protected boolean apilable;

    protected String descripcion;

    protected boolean isComerciable;

    protected String nombre;

    protected boolean refrigerado;

    protected int stockMax;

    protected int stockMin;

    protected List<DTOHistoricoPrecios> precio = new ArrayList<DTOHistoricoPrecios>();

    protected List<DTOArticulos_Existencia> articulos_existencias = new ArrayList<>();

    public DTOArticulo(Articulo entity) {

        this.id = entity.getId();

        this.apilable = entity.isApilable();

        this.descripcion = entity.getDescripcion();

        this.isComerciable = entity.isComerciable();

        this.nombre = entity.getNombre();

        this.refrigerado = entity.isRefrigerado();

        this.stockMax = entity.getStockMax();

        this.stockMin = entity.getStockMin();

        for (HistoricoPrecios i : entity.getPrecio())
            this.precio.add(new DTOHistoricoPrecios(i));

        for (Articulos_Existencia i : entity.getArticulos_existencias())
            this.articulos_existencias.add(new DTOArticulos_Existencia(i));

    }
}
