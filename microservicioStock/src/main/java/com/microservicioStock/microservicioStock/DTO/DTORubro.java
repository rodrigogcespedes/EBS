package com.microservicioStock.microservicioStock.DTO;

import java.util.ArrayList;
import java.util.List;
import com.microservicioStock.microservicioStock.local_models.stock.Articulo;
import com.microservicioStock.microservicioStock.local_models.stock.Insumo;
import com.microservicioStock.microservicioStock.local_models.stock.Manufacturado;
import com.microservicioStock.microservicioStock.local_models.stock.Rubro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTORubro extends BaseDTO<Rubro>{

    private String nombre;

    private List<DTORubro> pertenece = new ArrayList<DTORubro>();

    private List<DTOArticulo> articulos = new ArrayList<DTOArticulo>();

    public DTORubro(Rubro entity){

        this.id = entity.getId();

        this.nombre = entity.getNombre();

        for(Rubro i : entity.getPertenece())
            this.pertenece.add(new DTORubro(i));

        for (Articulo i : entity.getArticulos()){
            if(i.getClass().equals(Insumo.class)){
                this.articulos.add(new DTOInsumo((Insumo) i));
            }else if(i.getClass().equals(Manufacturado.class)){
                this.articulos.add(new DTOManufacturado((Manufacturado) i));
            }
        }
    }

    @Override
    public Rubro parseEntity() {

        Rubro entity = new Rubro();
        entity.setNombre(this.nombre);
        for(DTORubro i: this.pertenece)
            entity.getPertenece().add(i.parseEntity());
        for(DTOArticulo i: this.articulos)
            entity.getArticulos().add(i.parseEntity());

        entity.setId(this.id);
        return entity;
    }

    @Override
    public BaseDTO<Rubro> setGeneratedValues(BaseDTO<Rubro> dtoIn) {

        for(int i=0; i<this.pertenece.size(); i++)
            this.pertenece.get(i).setGeneratedValues(((DTORubro) dtoIn).getPertenece().get(i));

        for(int i=0; i<this.articulos.size(); i++)
            this.articulos.get(i).setGeneratedValues(((DTORubro) dtoIn).getArticulos().get(i));

        this.id = dtoIn.getId();
        return this;
    }
}
