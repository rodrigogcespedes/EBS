package com.microservicioStock.microservicioStock.DTO;

import com.microservicioStock.microservicioStock.local_models.stock.Articulo;
import com.microservicioStock.microservicioStock.local_models.stock.Manufacturado;
import com.microservicioStock.microservicioStock.local_models.stock.Receta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOManufacturado extends DTOArticulo {

    private List<DTOReceta> recetas = new ArrayList<>();

    public DTOManufacturado(Manufacturado entity) {

        super(entity);

        for (Receta i : entity.getRecetas())
            recetas.add(new DTOReceta(i));
    }

    @Override
    public Manufacturado parseEntity() {
        Manufacturado entity = new Manufacturado();

        //Por cada atributo
        entity.setApilable(this.apilable);
        entity.setComerciable(this.isComerciable);
        entity.setNombre(this.nombre);
        entity.setRefrigerado(this.isRefrigerado());
        entity.setStockMax(this.stockMax);
        entity.setId(this.id);
        entity.setDescripcion(this.descripcion);
        entity.setStockMin(this.stockMin);

        //Por cada atributo distribuido
        entity.setIdDistribExistencias(this.getIdDistribExistencias());

        //Por cada clase local
        for (DTOReceta dto : this.recetas)
            entity.getRecetas().add(dto.parseEntity());

        for (DTOHistoricoPrecios dto : this.precio)
            entity.getPrecio().add(dto.parseEntity());

        /*Deprecated
        for (DTOArticulos_Existencia dto : this.articulos_existencias)
            entity.getArticulos_existencias().add(dto.parseEntity());
*/


        return entity;
    }

    @Override
    public BaseDTO<Articulo> setGeneratedValues(BaseDTO<Articulo> dtoIn) {

        super.setGeneratedValues(dtoIn);

        for(int i=0; i<this.recetas.size(); i++)
            this.recetas.get(i).setGeneratedValues(((DTOManufacturado) dtoIn).getRecetas().get(i));

        return this;
    }
}
