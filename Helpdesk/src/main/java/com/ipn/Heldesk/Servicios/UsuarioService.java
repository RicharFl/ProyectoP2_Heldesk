package com.ipn.Heldesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Usuarios;

public interface UsuarioService {

	Usuarios CrearUsuario(Usuarios usuarios);
	
	Usuarios ActulizarUsurio(Usuarios usuarios);
	
	Set<Usuarios> ObtenerUsuarios(Usuarios usuarios);
	
	Usuarios ObetenerUsurio(Long id_usaurio);
	
	void EliminarEmpleado (Long id_usaurio);
	

	Usuarios BloquearUsuario(Usuarios usuarios);
	
	
	
	
}