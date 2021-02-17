package com.example.facturas.controllers;

import com.example.facturas.clients.PedidoClientRest;
import com.example.facturas.entities.Factura;
import com.example.facturas.local_models.Pedido;
import com.example.facturas.services.FacturaServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microFactura/facturas")
public class FacturaController extends BaseController<Factura, FacturaServiceImpl> {

    @Autowired
    private PedidoClientRest pedidoClientRest;

    private Gson gson = new Gson();


    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try{
            Factura factura = service.findById(id);
            Pedido pedido = gson.fromJson(pedidoClientRest.getOne(factura.getIdPedido()).getBody().toString(),Pedido.class);
            factura.setPedido(pedido);
            return ResponseEntity.status(HttpStatus.OK).body(factura);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }


}
