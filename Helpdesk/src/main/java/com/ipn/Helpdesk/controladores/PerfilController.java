package com.ipn.Helpdesk.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.Servicios.PerfilService;
import com.ipn.Helpdesk.modelo.entidad.Perfil;

@RestController
@RequestMapping("/IPN/helpdesk/perfil/")
@CrossOrigin("*")
public class PerfilController {
	@Autowired
	private PerfilService perfilService;

	// Este endpoint es didcado para la visualizacion de todos los perfiles a los
	// cuales puede optar un empleado

	@RequestMapping(value = "/", method = RequestMethod.GET)

	public ResponseEntity<?> ListaPerfilUsuarios1() {
		return ResponseEntity.ok(perfilService.ListaPerfiles());
	}

	// Este metodo buscara perfil por id perfil
		
	@GetMapping(value = "/{id_perfil}")

	public Perfil PerfilporId(@PathVariable("id_perfil") Long id_perfil) {
		return perfilService.ListaPerfilUnico(id_perfil);
	}

	@DeleteMapping(value = "/{id_perfil}")

	public void EliminarPerfil(@PathVariable("id_perfil") Long id_perfil) {
		perfilService.EliminarPerfil(id_perfil);
	}

	@PutMapping(value = "/")

	public Perfil ActulizarPerfilPorID(@RequestBody Perfil perfil) {
		return perfilService.ActulizarPerfil(perfil);
	}

	@PostMapping(value = "/")
	public ResponseEntity<Perfil> GuardarNuevoPerfil(@RequestBody Perfil perfil) {
		Perfil perfilAGuardar = perfilService.AgregarPerfil(perfil);

		return ResponseEntity.ok(perfilAGuardar);
	}

}