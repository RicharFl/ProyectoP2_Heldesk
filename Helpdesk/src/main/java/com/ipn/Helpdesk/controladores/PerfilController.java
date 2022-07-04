package com.ipn.Helpdesk.controladores;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ipn")
public class PerfilController {
    
       
        @RequestMapping(value = "/Nuevo",method=RequestMethod.GET )
        public String holaMundo()
        {
            return "Hola mundo desde REST-API";
        }
    }