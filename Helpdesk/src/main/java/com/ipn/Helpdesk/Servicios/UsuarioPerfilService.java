package com.ipn.Helpdesk.Servicios;

import java.util.Set;


import com.ipn.Helpdesk.modelo.entidad.UsuarioPerfil;

public interface UsuarioPerfilService {
	
	Set<UsuarioPerfil> ListaUasuariosPerfiles ();
	
	UsuarioPerfil ActulizaUsuarioPerfil (UsuarioPerfil perfil);
	
	UsuarioPerfil BuscaporUsuario( Long id_user);
	
	//UsuarioPerfil Buscaporperfil(  Long id_perfil);
	
	

}
