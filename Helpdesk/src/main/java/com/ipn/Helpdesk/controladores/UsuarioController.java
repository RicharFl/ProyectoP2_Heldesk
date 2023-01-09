package com.ipn.Helpdesk.controladores;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.modelo.entidad.Usuarios;
import com.ipn.Helpdesk.repositorios.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@RestController
@RequestMapping("/IPN/helpdesk/Usuario/")
public class UsuarioController {

	
	
	@Autowired
	private UsuarioRepository usuartioRepository;
	
	

	@GetMapping("/ListaUsuarios")
	public List<Usuarios> listarTodosLosUsuarios1() 
	{

		System.out.println("Entre a a la lista" + usuartioRepository.findAll() );
		return usuartioRepository.findAll();
		
	}
	
	
	//Este metodo buscara perfil por  id perfil 
	  
	@GetMapping (value = "/ListaUsuarios/{id}" )

	public Usuarios UsarioPorId(  @PathVariable("id") Long Id)  {
    	return usuartioRepository.getById(Id);
    }


	@DeleteMapping (value = "/EliminaUsuarios/" )

	public void EliminaUsuarios( Long Id)  {
    	 usuartioRepository.deleteById(Id);
    }
	
	
	@PutMapping (value = "/Actuliza_usuario/" )

	public Usuarios Actuliza_usuario( Long Id)  {
    	return usuartioRepository.save(null);
    }
	
	

	@GetMapping (value = "/Inserta_usuario/" )

	public Usuarios Inserta_usuario()  {
    	return usuartioRepository.save(null);
    }
	

	
	
	

}
