package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.PerfilService;
import com.ipn.Helpdesk.modelo.entidad.Perfil;
import com.ipn.Helpdesk.repositorios.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public Perfil AgregarPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilRepository.save(perfil);
	}

	@Override
	public Perfil ActulizarPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilRepository.save(perfil);
	}

	@Override
	public Set<Perfil> ListaPerfiles() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(perfilRepository.findAll());
	}

	@Override
	public Perfil ListaPerfilUnico(Long id_perfil) {
		// TODO Auto-generated method stub
		return perfilRepository.findById(id_perfil).get();
	}

	@Override
	public void EliminarPerfil(Long id_perfil) {

		// TODO Auto-generated method stub
		Perfil perfileliminado = new Perfil();
		perfileliminado.setId_per(id_perfil);
		perfilRepository.delete(perfileliminado);

	}

}
