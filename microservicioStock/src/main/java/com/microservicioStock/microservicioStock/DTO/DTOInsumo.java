package com.microservicioStock.microservicioStock.DTO;

import com.microservicioStock.microservicioStock.local_models.stock.Articulo;
import com.microservicioStock.microservicioStock.local_models.stock.Insumo;
import com.microservicioStock.microservicioStock.remote_models.DTOExistencia;
import com.microservicioStock.microservicioStock.remote_models.DTOProveedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOInsumo extends DTOArticulo{

    private Long idDistribProv;

    private DTOProveedor proveedor;

    //En ninguno hacen falta los DTOs Remotos
    public DTOInsumo(Insumo entity){
        super(entity);
        this.idDistribProv = entity.getIdDistribProv();
    }
    @Override
    public Insumo parseEntity() {
        //Siempre
        Insumo entity = new Insumo();

        //Por cada atributo
        entity.setIdDistribProv(this.idDistribProv);
        entity.setApilable(this.apilable);
        entity.setDescripcion(this.descripcion);
        entity.setComerciable(this.isComerciable);
        entity.setNombre(this.nombre);
        entity.setRefrigerado(this.isRefrigerado());
        entity.setStockMax(this.stockMax);
        entity.setStockMin(this.stockMin);
        entity.setId(this.id);

        //Por cada relacion local XtoMany
        for(DTOHistoricoPrecios dto: this.precio)
            entity.getPrecio().add(dto.parseEntity());

        // por cada XtoMany externo
        for(DTOExistencia dto : this.dtoExistencias)
            entity.getIdDistribExistencias().add(dto.getId());

        /*Deprecated
        for(DTOArticulos_Existencia dto: this.articulos_existencias)
            entity.getArticulos_existencias().add(dto.parseEntity());
        */

        //Siempre
        return entity;
    }

    @Override
    public BaseDTO<Articulo> setGeneratedValues(BaseDTO<Articulo> dtoIn) {
        //siempre que herede, el id va en la clase padre
        super.setGeneratedValues(dtoIn);

        return this;
    }
}
