package com.ipn.Helpdesk.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.modelo.entidad.Usuarios;
import com.ipn.Helpdesk.repositorios.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/IPN/api/v1/")
public class UsuarioController {

	
	
	@Autowired
	private UsuarioRepository usuartioRepository;

	@GetMapping("/Usuario")
	public List<Usuarios> listarTodosLosUsuarios() {
		return usuartioRepository.findAll();
		
	}
	
	

}
