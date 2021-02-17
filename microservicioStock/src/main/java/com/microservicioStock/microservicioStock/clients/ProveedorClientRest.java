package com.microservicioStock.microservicioStock.clients;

import com.microservicioStock.microservicioStock.remote_models.DTOExistencia;
import com.microservicioStock.microservicioStock.remote_models.DTOProveedor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microProveedores", url= "localhost:8080", fallback = ProveedorHystrixFallbackFactory.class)
public interface ProveedorClientRest {

    @GetMapping("/microProveedores/api/v1/proveedor/{id}")
    public ResponseEntity<?> getOneProveedor(@PathVariable Long id);

    @PostMapping("/microProveedores/api/v1/proveedor/")
    public ResponseEntity<?> saveProveedor(@RequestBody DTOProveedor entity);

    @PutMapping("/microProveedores/api/v1/proveedor/{id}")
    public ResponseEntity<?> updateProveedor(@PathVariable Long id,@RequestBody DTOProveedor entity);

    @DeleteMapping("/microProveedores/api/v1/proveedor/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable Long id);

    @GetMapping("/microProveedores/api/v1/existencia/{id}")
    public ResponseEntity<?> getOneExistencia(@PathVariable Long id);

    @PostMapping("/microProveedores/api/v1/existencia/")
    public ResponseEntity<?> saveExistencia(@RequestBody DTOExistencia entity);

    @PutMapping("/microProveedores/api/v1/existencia/{id}")
    public ResponseEntity<?> updateExistencia(@PathVariable Long id,@RequestBody DTOExistencia entity);

    @DeleteMapping("/microProveedores/api/v1/existencia/{id}")
    public ResponseEntity<?> deleteExistencia(@PathVariable Long id);
}
