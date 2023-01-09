package com.ipn.Helpdesk.controladores;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.Heldesk.Servicios.PerfilService;
import com.ipn.Heldesk.Servicios.ServiciosImpl.PerfilServiceImpl;
import com.ipn.Helpdesk.modelo.entidad.Perfil;

import com.ipn.Helpdesk.repositorios.PerfilRepository;

@RestController
@RequestMapping("/IPN/helpdesk/perfil/")

public class PerfilController {
    @Autowired
    private PerfilService perfilService ;
	
	@Autowired 
	private PerfilRepository perfilRepository;
	
	
	
	
	//	Este endpoint es didcado para la visualizacion de todos los perfiles a los cuales puede optar un empleado
		
		@RequestMapping (value = "/Lista_perfiles", method =RequestMethod.GET)
		
		  public  ResponseEntity<?> ListaPerfilUsuarios1()  {
	        	return  ResponseEntity.ok(perfilService.ListaPerfiles());
	        }
	        
	
	//Este metodo buscara perfil por  id perfil 
		  
			@GetMapping (value = "/Lista_perfil/{id}" )

			public Perfil PerfilporId( @PathVariable ("id") Long Id)  {
	        	return perfilService.ListaPerfilUnico(Id);
	        }
		
			
			@GetMapping (value = "/Lista_pef_prueba/" )
			public ResponseEntity<?> RecuperarId()  {
	        	return ResponseEntity.ok( perfilRepository.lista());
	        }
			
    
			@DeleteMapping (value = "/Elimina_perfil/" )

			public Perfil EliminaPerfil( Long Id)  {
	        	return (Perfil) perfilRepository.findAllById(null);
	        }
			
			
			@PutMapping (value = "/Actuliza_perfil/" )

			public Perfil Actulizar_perfil( Long Id)  {
	        	return perfilRepository.save(null);
	        }
			
			

			@GetMapping (value = "/Inserta_perfil/" )

			public Perfil Inserta_perfil()  {
	        	return perfilRepository.save(null);
	        }
			
        
    }