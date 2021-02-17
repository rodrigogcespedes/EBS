package com.example.pedidos.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocsController {
        @RequestMapping("/microPedido/docs")
        public String home() {
            return "redirect:/swagger-ui.html";
        }
}
