package com.example.facturas.local_models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoEstadoPedido{
    private Long id;
    private Date fechaCambio;

    private  EstadoPedido estadoPedido;

}
