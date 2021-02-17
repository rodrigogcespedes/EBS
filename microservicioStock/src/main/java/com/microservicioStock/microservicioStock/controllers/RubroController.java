package com.microservicioStock.microservicioStock.controllers;

import com.microservicioStock.microservicioStock.DTO.DTORubro;
import com.microservicioStock.microservicioStock.local_models.stock.Rubro;
import com.microservicioStock.microservicioStock.services.RubroServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "microStock/api/v1/rubro")
public class RubroController extends BaseControllerImpl<DTORubro, Rubro, RubroServiceImpl>{


}

