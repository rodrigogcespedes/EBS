package com.microservicioStock.microservicioStock.controllers;

import com.microservicioStock.microservicioStock.DTO.DTOManufacturado;
import com.microservicioStock.microservicioStock.local_models.stock.Manufacturado;
import com.microservicioStock.microservicioStock.services.ManufacturadoServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microStock/api/v1/manufacturado")
public class ManufacturadoController extends BaseControllerImpl<DTOManufacturado, Manufacturado, ManufacturadoServiceImpl>{


}

