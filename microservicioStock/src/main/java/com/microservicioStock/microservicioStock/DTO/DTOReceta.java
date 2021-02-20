package com.microservicioStock.microservicioStock.DTO;

import java.util.ArrayList;
import java.util.List;

import com.microservicioStock.microservicioStock.local_models.stock.Articulo;
import com.microservicioStock.microservicioStock.local_models.stock.Insumo;
import com.microservicioStock.microservicioStock.local_models.stock.Manufacturado;
import com.microservicioStock.microservicioStock.local_models.stock.Receta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOReceta extends BaseDTO<Receta> {

    private float costoElaboracion;

    private String instrucciones;

    private int tiempoElaboracion;

    private List<DTOArticulo> ingredientes = new ArrayList<DTOArticulo>();

    public DTOReceta(Receta entity) {

        this.id = entity.getId();

        this.costoElaboracion = entity.getCostoElaboracion();

        this.instrucciones = entity.getInstrucciones();

        this.tiempoElaboracion = entity.getTiempoElaboracion();

        for (Articulo i : entity.getIngredientes()) {
            if (i.getClass().equals(Insumo.class)) {
                this.ingredientes.add(new DTOInsumo((Insumo) i));
            } else if (i.getClass().equals(Manufacturado.class)) {
                this.ingredientes.add(new DTOManufacturado((Manufacturado) i));
            }
        }
    }

    @Override
    public Receta parseEntity() {

        Receta entity = new Receta();
        entity.setCostoElaboracion(this.costoElaboracion);
        entity.setInstrucciones(this.instrucciones);
        entity.setTiempoElaboracion(this.tiempoElaboracion);
        for (DTOArticulo i : this.ingredientes)
            entity.getIngredientes().add(i.parseEntity());
        entity.setId(this.id);
        return entity;
    }

    @Override
    public BaseDTO<Receta> setGeneratedValues(BaseDTO<Receta> dtoIn) {

        for(int i=0; i<this.ingredientes.size(); i++)
            this.ingredientes.get(i).setGeneratedValues(((DTOReceta) dtoIn).getIngredientes().get(i));

        this.id = dtoIn.getId();
        return this;
    }
}