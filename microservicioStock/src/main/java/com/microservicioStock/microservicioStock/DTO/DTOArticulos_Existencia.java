package com.microservicioStock.microservicioStock.DTO;

import com.microservicioStock.microservicioStock.local_models.stock.Articulos_Existencia;
import com.microservicioStock.microservicioStock.remote_models.DTOExistencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOArticulos_Existencia extends BaseDTO<Articulos_Existencia>{

    private Long id_existencia;

    //No agregado al generated values
    private DTOExistencia dtoExistencia;

    public DTOArticulos_Existencia(Articulos_Existencia entity){
        this.id = entity.getId();
        this.id_existencia = entity.getId_existencia();
    }

    @Override
    public Articulos_Existencia parseEntity() {

        Articulos_Existencia entity = new Articulos_Existencia();
        entity.setId_existencia(this.getId_existencia());
        entity.setId(this.id);
        return entity;
    }

    @Override
    public BaseDTO<Articulos_Existencia> setGeneratedValues(BaseDTO<Articulos_Existencia> dtoIn) {

        this.id = dtoIn.getId();
        return this;
    }
}
