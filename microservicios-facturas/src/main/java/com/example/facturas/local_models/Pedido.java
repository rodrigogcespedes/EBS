package com.example.facturas.local_models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pedido{

    @JsonProperty("id")
    private Long id;

    @JsonProperty("fechaPedido")
    private Date fechaPedido;

    @JsonProperty("isPagado")
    private boolean isPagado;

    @JsonProperty("montoTotal")
    private float montoTotal;

    @JsonProperty("retiroEnLocal")
    private boolean retiroEnLocal;


    private List<DetallePedido> detalles = new ArrayList<DetallePedido>();


    private List<MedioPago> medioPago;


    private List<HistoricoEstadoPedido> estadoPedido;

}
