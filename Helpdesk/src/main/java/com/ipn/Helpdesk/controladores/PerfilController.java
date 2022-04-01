package com.ipn.Helpdesk.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ipn")
public class PerfilController {
    
        @GetMapping ("/Hola")
        public String holaMundo()
        {
            return "Hola mundo desde REST-API";
        }
    }