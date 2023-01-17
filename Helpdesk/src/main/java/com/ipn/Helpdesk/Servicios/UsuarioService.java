package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.UsuarioPerfil;
import com.ipn.Helpdesk.modelo.entidad.Usuarios;

public interface UsuarioService {

	Usuarios CrearUsuario(Usuarios usuarios, Set<UsuarioPerfil> perfils) throws Exception;
	
	Usuarios ActulizarUsurio(Usuarios usuarios);
	
	Set<Usuarios> ObtenerUsuarios();
	
	Usuarios ObetenerUsurio(Long id_usaurio);
	
	void EliminarEmpleado (Long id_usaurio);
	

	Usuarios BloquearUsuario(Usuarios usuarios);
	
	
	
	
}
