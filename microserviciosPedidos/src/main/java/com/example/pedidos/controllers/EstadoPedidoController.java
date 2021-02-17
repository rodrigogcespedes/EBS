package com.example.pedidos.controllers;


import com.example.pedidos.entities.EstadoPedido;
import com.example.pedidos.services.EstadoPedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microPedido/estados")
public class EstadoPedidoController extends BaseController<EstadoPedido, EstadoPedidoServiceImpl>{


}
