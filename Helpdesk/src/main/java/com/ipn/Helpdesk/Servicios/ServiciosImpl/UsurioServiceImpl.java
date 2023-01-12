package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.UsuarioService;
import com.ipn.Helpdesk.modelo.entidad.Usuarios;
import com.ipn.Helpdesk.repositorios.UsuarioRepository;

@Service
public class UsurioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuarios CrearUsuario(Usuarios usuarios) {
		// GUarda el empleado
		return usuarioRepository.save(usuarios);
	}

	@Override
	public Usuarios ActulizarUsurio(Usuarios usuarios) {
		// actuliza usuario
		return usuarioRepository.save(usuarios);
	}

	@Override
	public Set<Usuarios> ObtenerUsuarios(Usuarios usuarios) {
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

}
