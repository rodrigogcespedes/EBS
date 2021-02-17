package com.example.facturas.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocsController {
        @RequestMapping("/microFactura/docs")
        public String home() {
            return "redirect:/swagger-ui.html";
        }
}
