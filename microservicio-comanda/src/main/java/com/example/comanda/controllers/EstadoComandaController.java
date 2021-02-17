package com.example.comanda.controllers;

import com.example.comanda.local_models.EstadoComanda;
import com.example.comanda.services.EstadoComandaServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microComanda/estados")
public class EstadoComandaController extends BaseController<EstadoComanda, EstadoComandaServiceImpl>{
}
