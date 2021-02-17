package com.microservicioProveedores.microservicioProveedores.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocsController {
        @RequestMapping("/microProveedores/docs")
        public String home() {
            return "redirect:/swagger-ui.html";
        }
}
