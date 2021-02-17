package com.microservicioStock.microservicioStock.remote_models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOUnidad {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nombre")
    private String nombre;
}
