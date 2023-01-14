package com.ipn.Helpdesk.controladores;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.Servicios.UsuarioService;
import com.ipn.Helpdesk.Servicios.ServiciosImpl.UsurioServiceImpl;
import com.ipn.Helpdesk.modelo.entidad.Usuarios;
import com.ipn.Helpdesk.repositorios.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController
@RequestMapping("/IPN/helpdesk/Usuario/")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuartioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/")
	public ResponseEntity<Usuarios> CrearUsaurio(@RequestBody Usuarios usuarios) {
		Usuarios usuarios2 = usuarioService.CrearUsuario(usuarios);
		return ResponseEntity.ok(usuarios2);
	}

	@PutMapping("/")
	public Usuarios ActulizarUsuario(@RequestBody Usuarios usuarios) {
		return usuarioService.ActulizarUsurio(usuarios);
	}

	@GetMapping("/")
	public ResponseEntity<?> ListarTodosLosUsuarios() {
		return ResponseEntity.ok(usuarioService.ObtenerUsuarios());
	}

	@GetMapping(value = "/{id}")

	public Usuarios UsarioPorId(@PathVariable("id") Long Id) {
		return usuarioService.ObetenerUsurio(Id);
	}

	@DeleteMapping(value = "/{id}")

	public void EliminaUsuarios(@PathVariable("id") Long Id) {
		usuartioRepository.deleteById(Id);
	}

}
