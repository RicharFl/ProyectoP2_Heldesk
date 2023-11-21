package com.ipn.Helpdesk.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.Servicios.UsuarioPerfilService;
import com.ipn.Helpdesk.modelo.entidad.UsuarioPerfil;
import com.ipn.Helpdesk.repositorios.PerfilUsuarioRepository;


@RestController

//@RequestMapping("/IPN/helpdesk/Usuario/")
@RequestMapping("/IPN/helpdesk/UsuarioPefil/")
@CrossOrigin("*")

public class UsuarioPerfilController {
	
@Autowired
private UsuarioPerfilService perfilService;

@Autowired 
private PerfilUsuarioRepository perfilUsuarioRepository;

@GetMapping ("/")
public ResponseEntity<?> ListatodosLosperfilesyUsarios ()
{
	return ResponseEntity.ok(perfilService.ListaUasuariosPerfiles());
}

@PutMapping ("/")
public UsuarioPerfil actulizaUsarioPerfil (@RequestBody UsuarioPerfil perfil)
{
	return perfilService.ActulizaUsuarioPerfil(perfil);
	}



@GetMapping ("/{id_user}")

public UsuarioPerfil perfilporUsuario(@PathVariable ("id_user") Long id_user)
{
	return perfilService.BuscaporUsuario(id_user);
	}
@GetMapping ("/perfil/{id_perfil}")
public ResponseEntity<?> perfilporid_perfil(@PathVariable ("id_perfil") Long id_perfil)
{
	return ResponseEntity.ok(perfilUsuarioRepository.findByPerfil(id_perfil));
	}




}
