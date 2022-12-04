package com.ipn.Helpdesk.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.modelo.entidad.perfil;
import com.ipn.Helpdesk.repositorios.PerfilRepository;

@RestController
@RequestMapping("/IPN/api/v2/")
public class PerfilController {
    
	
	@Autowired 
	private PerfilRepository perfilRepository;
	
        @RequestMapping(value = "/Perfilv1",method=RequestMethod.GET )
        public String holaMundo()
        {
            return "Hola mundo desde REST-API";
        }
        
        @GetMapping ("/Perfilv2")
        public List<perfil> ListaPerfilUsuarios()  {
        	return perfilRepository.findAll();
        }
        
        
    }