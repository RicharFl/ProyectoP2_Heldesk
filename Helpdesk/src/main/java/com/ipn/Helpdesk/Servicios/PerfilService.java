package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Perfil;

public interface PerfilService {

	Perfil AgregarPerfil (Perfil perfil);
	
	Perfil ActulizarPerfil (Perfil perfil);
	
	Set<Perfil> ListaPerfiles();
	
	Perfil ListaPerfilUnico(Long id_perfil);
	
	void EliminarPerfil (Long id_perfil);
	
	
}
