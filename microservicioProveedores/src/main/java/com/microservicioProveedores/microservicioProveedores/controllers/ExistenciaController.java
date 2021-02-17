package com.microservicioProveedores.microservicioProveedores.controllers;

import com.microservicioProveedores.microservicioProveedores.local_models.proveedores.Existencia;
import com.microservicioProveedores.microservicioProveedores.services.ExistenciaServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microProveedores/api/v1/existencia")
public class ExistenciaController extends BaseControllerImpl<Existencia, ExistenciaServiceImpl>{


}

