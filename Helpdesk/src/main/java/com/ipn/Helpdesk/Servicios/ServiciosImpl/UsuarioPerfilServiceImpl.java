package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.UsuarioPerfilService;
import com.ipn.Helpdesk.modelo.entidad.UsuarioPerfil;
import com.ipn.Helpdesk.repositorios.PerfilUsuarioRepository;

@Service
public class UsuarioPerfilServiceImpl implements UsuarioPerfilService{

	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;
	
	@Override
	public Set<UsuarioPerfil> ListaUasuariosPerfiles() {
		// TODO Auto-generated method stub
		//return new LinkedHashSet<>(usuarioRepository.findAll());
		return new LinkedHashSet<>(perfilUsuarioRepository.findAll());
	}

	@Override
	public UsuarioPerfil ActulizaUsuarioPerfil(UsuarioPerfil perfil) {
		// TODO Auto-generated method stub
		return perfilUsuarioRepository.save(perfil);
	}

	@Override
	public UsuarioPerfil BuscaporUsuario(Long id_user) {
		// TODO Auto-generated method stub
		//return almacenRepository.findById(Id_almacen).get();
		return perfilUsuarioRepository.findByUsuarios(id_user);
	}
/*
	@Override
	public List<UsuarioPerfil> Buscaporperfil(Long id_perfil) {	
		// TODO Auto-generated method stub
		return ListperfilUsuarioRepository.findByPerfil(id_perfil);
	}
*/
}
