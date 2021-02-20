package com.microservicioStock.microservicioStock.DTO;

import com.microservicioStock.microservicioStock.local_models.stock.HistoricoPrecios;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOHistoricoPrecios extends BaseDTO<HistoricoPrecios>{

    private Date fechaCambio;

    private float precio;

    public DTOHistoricoPrecios(HistoricoPrecios entity){

        this.id = entity.getId();

        this.fechaCambio = entity.getFechaCambio();

        this.precio = entity.getPrecio();

    }

    @Override
    public HistoricoPrecios parseEntity() {

        HistoricoPrecios entity = new HistoricoPrecios();
        entity.setPrecio(this.precio);
        entity.setFechaCambio(this.fechaCambio);
        entity.setId(this.id);
        return entity;
    }

    @Override
    public BaseDTO<HistoricoPrecios> setGeneratedValues(BaseDTO<HistoricoPrecios> dtoIn) {

        this.id = dtoIn.getId();
        return this;
    }
}
