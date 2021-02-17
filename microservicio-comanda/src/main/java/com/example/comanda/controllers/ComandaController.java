package com.example.comanda.controllers;

import com.example.comanda.local_models.Comanda;
import com.example.comanda.services.ComandaServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microComanda/comandas")
public class ComandaController extends BaseController<Comanda, ComandaServiceImpl>{

}
