	package com.microservicioProveedores.microservicioProveedores.remote_models;

    import com.fasterxml.jackson.annotation.JsonProperty;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import java.util.Date;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class HistoricoPrecios{

        @JsonProperty("fechaCambio")
        private Date fechaCambio;

        @JsonProperty("precio")
        private float precio;

        @JsonProperty("id")
        private Long id;
    }
