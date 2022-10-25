package com.ipn.Helpdesk.controladores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
@RestController 
@RequestMapping("/IPN/Usuario")
public class UsuarioController { 
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	
	@PostMapping
	public ResponseEntity<T>E
	
}
