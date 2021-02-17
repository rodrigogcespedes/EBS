package com.microservicioProveedores.microservicioProveedores.controllers;

import com.microservicioProveedores.microservicioProveedores.local_models.proveedores.Proveedor;
import com.microservicioProveedores.microservicioProveedores.services.ProveedorServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microProveedores/api/v1/proveedor")
public class ProveedorController extends BaseControllerImpl<Proveedor, ProveedorServiceImpl>{

}

