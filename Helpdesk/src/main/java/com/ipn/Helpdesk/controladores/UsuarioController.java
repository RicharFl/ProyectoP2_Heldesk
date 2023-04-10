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

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		String PasswordSHA256;
		PasswordSHA256 = sha256(usuarios.getPassword());
		System.out.println("Este es el  Password " + usuarios.getPassword() + "Este es el HAS 256 = " + PasswordSHA256);
		usuarios.setPassword(PasswordSHA256);

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

		return usuarioService.CrearUsuario(usuarios, perfils);
	}

	@GetMapping("/Login")
	public String LoginUsuario(@RequestBody Usuarios usuarios) throws Exception {
		
		Usuarios usuarioshast = new Usuarios();
		
	
		//String auxPaswword = usuarioshast.getPassword();
		//System.out.println("Paswword de usuarios antes de entrar a IF es= " + usuarios.getPassword() + " \n");
		usuarioshast = RetornaHast(usuarios);
		
		//System.out.println("Paswword de usuarios antes de entrar a IF y pásando el hast es= " + usuarios.getPassword() + " \n");
		//usuariocoimpleto = usuarioService.BuscaporUserName(usuarios.getUsername());
		if ((usuarioService.BuscaporUserName(usuarios.getUsername())).getId_user() != null) {
			System.out.println("El usuario es = "+ usuarios.getId_user());
			//System.out.println("Paswword de usuarios es= " + usuarios.getPassword() + " \n");
			//System.out.println("Paswword de usuarioshast es= " + usuarioshast.getPassword() + " \n");
			
		
			String pss1= (usuarioService.ObetenerUsurio(usuarios.getId_user())).getPassword();
			String pss2= usuarioshast.getPassword() ;
			
			System.out.println("Paswword de usuarios es=" + pss1 + "*\n");
			System.out.println("Paswword de usuarioshast es=" + pss2 + "*\n");
			if (pss1 == pss2) {
				System.out.println(" La autentificacion del Usario fue correcta");
				return "true";
			}
			else
			{
				System.out.println("La autentificacion del empleado es incorrecta password erronio");
				return "false";
			}

		} 
		else 
		{
			System.out.println("No se encontro ningun registro del empleado");
			return "false";
		}
	


	}

	public Usuarios RetornaHast(@RequestBody Usuarios usuarios) throws Exception {
		String PasswordSHA256;
		PasswordSHA256 = sha256(usuarios.getPassword());
		System.out.println("Este es el  Password " + usuarios.getPassword() + "  Este es el HAS 256 = " + PasswordSHA256);
		usuarios.setPassword(PasswordSHA256);
		return usuarios;
	}

	public static String sha256(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
		return convertByteArrayToHexString(hash);
	}

	private static String convertByteArrayToHexString(byte[] arrayBytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuffer.toString();
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
