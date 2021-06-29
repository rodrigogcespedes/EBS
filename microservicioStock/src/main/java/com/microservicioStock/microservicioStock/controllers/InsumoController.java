package com.microservicioStock.microservicioStock.controllers;

import com.google.gson.Gson;
import com.microservicioStock.microservicioStock.DTO.DTOArticulos_Existencia;
import com.microservicioStock.microservicioStock.DTO.DTOInsumo;
import com.microservicioStock.microservicioStock.clients.ProveedorClientRest;
import com.microservicioStock.microservicioStock.local_models.stock.Insumo;
import com.microservicioStock.microservicioStock.remote_models.DTOExistencia;
import com.microservicioStock.microservicioStock.remote_models.DTOProveedor;
import com.microservicioStock.microservicioStock.services.InsumoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microStock/api/v1/insumo")
public class InsumoController extends BaseControllerImpl<DTOInsumo,Insumo, InsumoServiceImpl> {

    @Autowired
    private ProveedorClientRest provClient;

    private Gson gson = new Gson();

//    Generico
//    public List xtoMany(List<Long> ids, ResponseEntity entity, Class dtoClass){
//        List dtos = new ArrayList();
//        for(Long a : ids)
//            dtos.add(gson.fromJson(entity.getBody().toString(), dtoClass));
//        return dtos;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            //este es el buscar
            //Insumo i = service.findById(id);
            DTOInsumo dto = new DTOInsumo(service.findById(id));

            //para XtoOne
            DTOProveedor prov = gson.fromJson(provClient.getOneProveedor(dto.getIdDistribProv()).getBody().toString(), DTOProveedor.class);
            dto.setProveedor(prov);

            //para XtoMany
            for(Long a : dto.getIdDistribExistencias())
                dto.getDtoExistencias().add(gson.fromJson(provClient.getOneExistencia(a).getBody().toString(), DTOExistencia.class));

            //Generico
            //dto.setDtoExistencias(xtoMany(dto.getIdDistribExistencias(), ));
            //Try Functional

            /*Deprecated
            for (DTOArticulos_Existencia a : dto.getArticulos_existencias())
                a.setDtoExistencia(gson.fromJson(provClient.getOneExistencia(a.getId_existencia()).getBody().toString(), DTOExistencia.class));
             */

            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody DTOInsumo dto) {
        try {
            // para XtoOne
            DTOProveedor prov = gson.fromJson(provClient.getOneProveedor(dto.getIdDistribProv()).getBody().toString(), DTOProveedor.class);
            dto.setProveedor(prov);

            //para XtoMany
            for(Long a : dto.getIdDistribExistencias())
                dto.getDtoExistencias().add(gson.fromJson(provClient.getOneExistencia(a).getBody().toString(), DTOExistencia.class));

            /*Deprecated
            for (DTOArticulos_Existencia a : dto.getArticulos_existencias())
                a.setDtoExistencia(gson.fromJson(provClient.getOneExistencia(a.getId_existencia()).getBody().toString(), DTOExistencia.class));
             */

            dto.setGeneratedValues(new DTOInsumo(service.save(dto.parseEntity())));

            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DTOInsumo dto) {
        try {
            // para XtoOne
            DTOProveedor prov = gson.fromJson(provClient.getOneProveedor(dto.getIdDistribProv()).getBody().toString(), DTOProveedor.class);
            dto.setProveedor(prov);

            //para XtoMany
            for(Long a : dto.getIdDistribExistencias())
                dto.getDtoExistencias().add(gson.fromJson(provClient.getOneExistencia(a).getBody().toString(), DTOExistencia.class));

            //
            //for(Long a : dto.getIdDistribExistencias())
            //                dto.getDtoExistencias().add(gson.fromJson(provClient.getOneClase2(a).getBody().toString(), DTOExistencia.class));

            /* Deprecated
            for(DTOArticulos_Existencia a : dto.getArticulos_existencias())
                a.setDtoExistencia(gson.fromJson(provClient.getOneExistencia(a.getId_existencia()).getBody().toString(), DTOExistencia.class));
            */

            dto.setGeneratedValues(new DTOInsumo(service.update(id, dto.parseEntity())));

            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }

    @PostMapping("/subordinada")
    public ResponseEntity<?> saveSubordinada(@RequestBody DTOInsumo dto) {
        try {
            // para XtoOne
            DTOProveedor prov = gson.fromJson(provClient
                            .saveProveedor(dto.getProveedor())
                            .getBody()
                            .toString()
                    , DTOProveedor.class);
            dto.setIdDistribProv(prov.getId());
            dto.getProveedor().setId(prov.getId());

            // para XtoMany
            for(DTOExistencia a : dto.getDtoExistencias()){
                DTOExistencia dtoExistencia = gson.fromJson(provClient
                                .saveExistencia(a)
                                .getBody()
                                .toString()
                        , DTOExistencia.class);
                dto.getIdDistribExistencias().add(dtoExistencia.getId());
                a.setId(dtoExistencia.getId());
            }

            /*Deprecated
            for (DTOArticulos_Existencia a : dto.getArticulos_existencias()) {
                DTOExistencia dtoExistencia = gson.fromJson(provClient
                                .saveExistencia(a.getDtoExistencia())
                                .getBody()
                                .toString()
                        , DTOExistencia.class);
                a.setId_existencia(dtoExistencia.getId());
                a.getDtoExistencia().setId(dtoExistencia.getId());
            }
            */

            dto.setGeneratedValues(new DTOInsumo(service.save(dto.parseEntity())));

            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }

    @PutMapping("/subordinada/{id}")
    public ResponseEntity<?> updateSubordinada(@PathVariable Long id, @RequestBody DTOInsumo dto) {
        try {

            if (dto.getIdDistribProv() == 0) {
                DTOProveedor prov = gson.fromJson(provClient
                        .saveProveedor(dto.getProveedor())
                        .getBody()
                        .toString()
                        , DTOProveedor.class);
                dto.setIdDistribProv(prov.getId());
            } else provClient.updateProveedor(dto.getIdDistribProv(), dto.getProveedor());

            // para XtoMany
            for(DTOExistencia a : dto.getDtoExistencias()){
                if(a.getId() == 0) {
                    DTOExistencia dtoExistencia = gson.fromJson(provClient
                                    .saveExistencia(a)
                                    .getBody()
                                    .toString()
                            , DTOExistencia.class);
                    dto.getIdDistribExistencias().add(dtoExistencia.getId());
                    a.setId(dtoExistencia.getId());
                }else provClient.updateExistencia(a.getId(),a);
            }

            /*Deprecated
            for (DTOArticulos_Existencia a : dto.getArticulos_existencias()) {
                if (a.getId_existencia() == 0) {
                    DTOExistencia DTOExistencia = gson.fromJson(provClient
                                    .saveExistencia(a.getDtoExistencia())
                                    .getBody()
                                    .toString()
                                    , DTOExistencia.class);
                    a.setId_existencia(DTOExistencia.getId());
                    a.getDtoExistencia().setId(DTOExistencia.getId());
                }else provClient.updateExistencia(a.getId_existencia(),a.getDtoExistencia());
            }
            */

            dto.setGeneratedValues(new DTOInsumo(service.update(id, dto.parseEntity())));

            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }

    @DeleteMapping("/subordinada/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{

            DTOInsumo dto = new DTOInsumo(service.findById(id));

            // XtoOne
            provClient.deleteProveedor(dto.getIdDistribProv());

            // XtoMany
            for(Long a : dto.getIdDistribExistencias())
                provClient.deleteExistencia(a);

            /* Deprecated
            for(DTOArticulos_Existencia a :(dto).getArticulos_existencias())
                provClient.deleteExistencia(a.getId_existencia());
            */

            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }
}