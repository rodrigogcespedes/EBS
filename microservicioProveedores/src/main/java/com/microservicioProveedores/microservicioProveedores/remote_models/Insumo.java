package com.microservicioProveedores.microservicioProveedores.remote_models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Insumo{

    @JsonProperty("id")
    private Long id;

    @JsonProperty("apilable")
    protected boolean apilable;

    @JsonProperty("descripcion")
    protected String descripcion;

    @JsonProperty("isComerciable")
    protected boolean isComerciable;

    @JsonProperty("nombre")
    protected String nombre;

    @JsonProperty("refrigerado")
    protected boolean refrigerado;

    @JsonProperty("stockMax")
    protected int stockMax;

    @JsonProperty("sotickMin")
    protected int stockMin;

    @JsonProperty("precio")
    private List<HistoricoPrecios> precio = new ArrayList<HistoricoPrecios>();

    @JsonProperty("idDistribProv")
    private Long idDistribProv;
}
