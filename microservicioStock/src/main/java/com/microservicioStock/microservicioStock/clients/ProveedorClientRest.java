package com.microservicioStock.microservicioStock.clients;

import com.microservicioStock.microservicioStock.remote_models.DTOExistencia;
import com.microservicioStock.microservicioStock.remote_models.DTOProveedor;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "microProveedores", fallback = ProveedorHystrixFallbackFactory.class)
@FeignClient(name = "microProveedores")
public interface ProveedorClientRest {

    @GetMapping("/microProveedores/api/v1/proveedor/{id}")
    @CircuitBreaker(name="getOneProveedorFallBack",fallbackMethod = "getOneProveedorFallback")
    public ResponseEntity<?> getOneProveedor(@PathVariable Long id);

    @PostMapping("/microProveedores/api/v1/proveedor/")
    @CircuitBreaker(name="saveProveedorFallBack",fallbackMethod = "saveProveedorFallback")
    public ResponseEntity<?> saveProveedor(@RequestBody DTOProveedor entity);

    @PutMapping("/microProveedores/api/v1/proveedor/{id}")
    @CircuitBreaker(name="updateProveedorFallBack",fallbackMethod = "updateProveedorFallback")
    public ResponseEntity<?> updateProveedor(@PathVariable Long id,@RequestBody DTOProveedor entity);

    @DeleteMapping("/microProveedores/api/v1/proveedor/{id}")
    @CircuitBreaker(name="deleteProveedorFallBack",fallbackMethod = "deleteProveedorFallback")
    public ResponseEntity<?> deleteProveedor(@PathVariable Long id);

    @GetMapping("/microProveedores/api/v1/existencia/{id}")
    @CircuitBreaker(name="getOneExistenciaFallBack",fallbackMethod = "getOneExistenciaFallback")
    public ResponseEntity<?> getOneExistencia(@PathVariable Long id);

    @PostMapping("/microProveedores/api/v1/existencia/")
    @CircuitBreaker(name="saveExistenciaFallBack",fallbackMethod = "saveExistenciaFallback")
    public ResponseEntity<?> saveExistencia(@RequestBody DTOExistencia entity);

    @PutMapping("/microProveedores/api/v1/existencia/{id}")
    @CircuitBreaker(name="updateExistenciaFallBack",fallbackMethod = "updateExistenciaFallback")
    public ResponseEntity<?> updateExistencia(@PathVariable Long id,@RequestBody DTOExistencia entity);

    @DeleteMapping("/microProveedores/api/v1/existencia/{id}")
    @CircuitBreaker(name="deleteExistenciaFallBack",fallbackMethod = "deleteExistenciaFallback")
    public ResponseEntity<?> deleteExistencia(@PathVariable Long id);

    public default ResponseEntity<?> getOneProveedorFallback(Long id, Exception e) {
        return ResponseEntity.status(HttpStatus.OK).body("{id:0}");
    }
    public default ResponseEntity<?> saveProveedorFallback(Long id, Exception e) {
        return ResponseEntity.status(HttpStatus.OK).body("{id:0}");
    }
    public default ResponseEntity<?> updateProveedorFallback(Long id, Exception e) {
        return ResponseEntity.status(HttpStatus.OK).body("{id:0}");
    }
    public default ResponseEntity<?> deleteProveedorFallback(Long id, Exception e) {
        return ResponseEntity.status(HttpStatus.OK).body("{id:0}");
    }
    public default ResponseEntity<?> getOneExistenciaFallback(Long id, Exception e) {
        return ResponseEntity.status(HttpStatus.OK).body("{id:0}");
    }
    public default ResponseEntity<?> saveExistenciaFallback(Long id, Exception e) {
        return ResponseEntity.status(HttpStatus.OK).body("{id:0}");
    }
    public default ResponseEntity<?> updateExistenciaFallback(Long id, Exception e) {
        return ResponseEntity.status(HttpStatus.OK).body("{id:0}");
    }
    public default ResponseEntity<?> deleteExistenciaFallback(Long id, Exception e) {
        return ResponseEntity.status(HttpStatus.OK).body("{id:0}");
    }
}