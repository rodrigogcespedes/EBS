package com.example.pedidos.controllers;


import com.example.pedidos.entities.Pedido;
import com.example.pedidos.services.PedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microPedido/pedidos")
public class PedidoController extends BaseController<Pedido, PedidoServiceImpl>{

}
