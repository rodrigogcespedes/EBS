package com.microservicioStock.microservicioStock.clients;

import com.microservicioStock.microservicioStock.remote_models.DTOExistencia;
import com.microservicioStock.microservicioStock.remote_models.DTOProveedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProveedorHystrixFallbackFactory implements ProveedorClientRest{

    @Override
    public ResponseEntity<?> getOneProveedor(Long id) {
        DTOProveedor dto = DTOProveedor.builder()
                .id(0L)
                .contacto("notFound")
                .razonSocial("notFound")
                .build();
        System.out.println("paso");
        return ResponseEntity.status(HttpStatus.OK).body(dto);
//        return ResponseEntity.status(HttpStatus.OK).body("{\"id\":1,\"razonSocial\":\"prov1\",\"contacto\":\"prov1\"}");
    }

    @Override
    public ResponseEntity<?> saveProveedor(DTOProveedor entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateProveedor(Long id, DTOProveedor entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteProveedor(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getOneExistencia(Long id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"id\":0,\"cantActual\": 20,\"cantEntrada\": 20,\"expresadoEn\": {\"id\": 0},\"proveedor\": {\"id\": 0}}}");
    }

    @Override
    public ResponseEntity<?> saveExistencia(DTOExistencia entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateExistencia(Long id, DTOExistencia entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteExistencia(Long id) {
        return null;
    }
}
