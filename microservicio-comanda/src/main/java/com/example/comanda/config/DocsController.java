package com.example.comanda.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocsController {
        @RequestMapping("/microComanda/docs")
        public String home() {
            return "redirect:/swagger-ui.html";
        }
}
