package com.example.pedidos.controllers;

import com.example.pedidos.entities.MedioPago;
import com.example.pedidos.services.MedioPagoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microPedido/pagos")
public class MedioPagoController extends BaseController<MedioPago, MedioPagoServiceImpl>{

}
