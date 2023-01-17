package com.ipn.Helpdesk.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.Servicios.UsuarioService;
import com.ipn.Helpdesk.Servicios.ZonaEstadosService;
import com.ipn.Helpdesk.modelo.entidad.Perfil;
import com.ipn.Helpdesk.modelo.entidad.UsuarioPerfil;
import com.ipn.Helpdesk.modelo.entidad.Usuarios;
import com.ipn.Helpdesk.modelo.entidad.ZonaEstados;
import com.ipn.Helpdesk.repositorios.UsuarioRepository;
import com.ipn.Helpdesk.repositorios.ZonaEstadosRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController
@RequestMapping("/IPN/helpdesk/Usuario/")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuartioRepository;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired 
	private ZonaEstadosService estadosService;

	@PostMapping("/")
	public Usuarios CrearUsaurio(@RequestBody Usuarios usuarios) throws Exception {
		
		ZonaEstados zonaEstados = new ZonaEstados();
		zonaEstados = estadosService.ListarZonaEstadoUnica(usuarios.getZonaestados().getId_zon());

		System.out.println("Id_zonas Inyectado = " + usuarios.getZonaestados().getId_zon());
		Set<UsuarioPerfil> perfils = new HashSet<>();
		Perfil perfil = new Perfil();
		perfil.setId_per(7L);
		perfil.setNom_per("Invitado");
		
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
		usuarios.setZonaestados(zonaEstados);
		usuarioPerfil.setUsuarios(usuarios);
		usuarioPerfil.setPerfil(perfil);
		
		perfils.add(usuarioPerfil);
	
		return  usuarioService.CrearUsuario(usuarios, perfils);
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
