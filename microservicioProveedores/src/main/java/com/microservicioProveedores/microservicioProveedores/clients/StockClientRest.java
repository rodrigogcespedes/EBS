package com.microservicioProveedores.microservicioProveedores.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microStock", url= "localhost:8080")
public interface StockClientRest {

    @GetMapping("microStock/api/v1/insumo/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id);

}
