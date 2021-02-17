package com.example.facturas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-pedidos", url = "localhost:8080")
public interface PedidoClientRest {

    @GetMapping("/microPedido/pedidos/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id);
}
