package com.ipn.Helpdesk.repositorios;



import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipn.Helpdesk.modelo.entidad.UsuarioPerfil;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<UsuarioPerfil, Long>{
	
	
	public  UsuarioPerfil findByUsuarios(Long id_user);
	
	//public  UsuarioPerfil findByPerfil(Long id_perfil);
	public Set<UsuarioPerfil> findByPerfil (Long id_perfil );

}
