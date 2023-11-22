package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.UsuarioService;
import com.ipn.Helpdesk.excepciones.UsuarioFoundException;

import com.ipn.Helpdesk.modelo.entidad.Usuarios;

import com.ipn.Helpdesk.repositorios.UsuarioRepository;

@Service
public class UsurioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	

	@Override
	public Usuarios CrearUsuario(Usuarios usuarios ) throws Exception {
		Usuarios usuarios2 = usuarioRepository.findByUsername(usuarios.getUsername());
		
		
		System.out.println("Esta es la informacion del usuario" );
		if (usuarios2 != null) {
			System.out.println("El Usuario ya Existe");
			throw new UsuarioFoundException("El usuario ya esta presente");
		} else {
			
			
			usuarios2 = usuarioRepository.save(usuarios);
		}

		return usuarios2;
	}

	@Override
	public Usuarios ActulizarUsurio(Usuarios usuarios) {
		// actuliza usuario
		return usuarioRepository.save(usuarios);
	}

	@Override
	public Set<Usuarios> ObtenerUsuarios() {
		// lista todo los empleados con todos los atributos
		return new LinkedHashSet<>(usuarioRepository.findAll());
	}

	@Override
	public Usuarios ObetenerUsurio(Long id_usaurio) {
		// Obtenemos solo un empleado
		return usuarioRepository.findById(id_usaurio).get();
	}

	@Override
	public void EliminarEmpleado(Long id_usaurio) {

		Usuarios usuario = new Usuarios();
		usuario.setId_user(id_usaurio);
		usuarioRepository.delete(usuario);

	}

	@Override
	public Usuarios BloquearUsuario(Usuarios usuarios) {
		//
		return usuarioRepository.save(usuarios);
	}

	@Override
	public Usuarios BuscaporUserName(String username) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsername(username);
	}

}
