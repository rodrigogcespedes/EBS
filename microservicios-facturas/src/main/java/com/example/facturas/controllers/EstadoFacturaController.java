package com.example.facturas.controllers;

import com.example.facturas.entities.EstadoFactura;
import com.example.facturas.services.EstadoFacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microFactura/estados")
public class EstadoFacturaController extends BaseController<EstadoFactura, EstadoFacturaServiceImpl>{
}
