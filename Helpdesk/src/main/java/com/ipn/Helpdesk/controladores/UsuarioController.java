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



import com.ipn.Helpdesk.modelo.entidad.Usuarios;

import com.ipn.Helpdesk.repositorios.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
	
	@PutMapping("/actulizar-Password/")
	public Usuarios ActulizarUsuario_PASSWORD(@RequestBody Usuarios usuarios) throws Exception {
		String PasswordSHA256;
		PasswordSHA256 = sha256(usuarios.getPassword());
		//System.out.println("Este es el  Password " + usuarios.getPassword() + "Este es el HAS 256 = " + PasswordSHA256);
		usuarios.setPassword(PasswordSHA256);
		return usuarioService.ActulizarUsurio(usuarios);
	}

	@PostMapping("/")
	public Usuarios CrearUsaurio(@RequestBody Usuarios usuarios) throws Exception {

	
		String PasswordSHA256;
		PasswordSHA256 = sha256(usuarios.getPassword());
		//System.out.println("Este es el  Password " + usuarios.getPassword() + "Este es el HAS 256 = " + PasswordSHA256);
		usuarios.setPassword(PasswordSHA256);

		//System.out.println("Id_zonas Inyectado = " + usuarios.getZonaestados().getId_zon());

		return usuarioService.CrearUsuario(usuarios);
	}
	


	@PostMapping("/Login")
	public String LoginUsuario(@RequestBody Usuarios usuarioss) throws Exception {

		//System.out.println("El argunto del empleado es " + usuarioss.toString());
		Usuarios usuarioshast = new Usuarios();

		// String auxPaswword = usuarioshast.getPassword();
		// System.out.println("Paswword de usuarios antes de entrar a IF es= " +
		// usuarios.getPassword() + " \n");
		usuarioshast = RetornaHast(usuarioss);
		//String NameUserAux = (usuarioService.BuscaporUserName(usuarioss.getUsername()).getUsername());
		 //System.out.println(" Esto es lo que devuelve NameUserAux" + NameUserAux + "\n");
		// System.out.println("Paswword de usuarios antes de entrar a IF y pásando el
		// hast es= " + usuarios.getPassword() + " \n");
		// usuariocoimpleto = usuarioService.BuscaporUserName(usuarios.getUsername());
		if (usuarioService.BuscaporUserName(usuarioss.getUsername()) != null ) {
		/// System.out.println("El usuario es = "+ NameUserAux);
			// System.out.println("Paswword de usuarios es= " + usuarios.getPassword() + "
			// \n");
			// System.out.println("Paswword de usuarioshast es= " +
			// usuarioshast.getPassword() + " \n");

			String pss1 = ((usuarioService.BuscaporUserName(usuarioss.getUsername())).getPassword()).toString();

			
			String pss2 = (usuarioshast.getPassword()).toString();
		
			//System.out.println("Paswword de usuarios es=" + pss1 + "*\n");
			//System.out.println("Paswword de usuarioshast es=" + pss2 + "*\n");
		System.out.println("Estoy en el Login");

			if (pss1.equals(pss2)) {
				System.out.println(" La autentificacion del Usario fue correcta");
				return "true";
			} else {
				System.out.println("La autentificacion del empleado es incorrecta password erronio");
				return "false";
			}

		} else {
			System.out.println("No se encontro ningun registro del empleado");
			return "false";
		}

	}
	
	

	public Usuarios RetornaHast(@RequestBody Usuarios usuarios) throws Exception {
		String PasswordSHA256;
		PasswordSHA256 = sha256(usuarios.getPassword());
		// System.out.println("Este es el Password " + usuarios.getPassword() + " Este
		// es el HAS 256 = " + PasswordSHA256);
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

	@GetMapping("/userName/{userName}")
	public Usuarios UsarioPorId(@PathVariable("userName") String userName) {
		return usuarioService.BuscaporUserName(userName);
	}

	@GetMapping(value = "/id/{id}")	
	public Usuarios UsarioPorId(@PathVariable("id") Long Id) {
		return usuarioService.ObetenerUsurio(Id);
	}

	@DeleteMapping(value = "/{id}")
	public void EliminaUsuarios(@PathVariable("id") Long Id) {
		usuartioRepository.deleteById(Id);
	}

}
