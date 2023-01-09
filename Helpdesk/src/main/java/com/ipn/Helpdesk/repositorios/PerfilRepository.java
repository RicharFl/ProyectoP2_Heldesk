package com.ipn.Helpdesk.repositorios;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ipn.Helpdesk.modelo.entidad.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long>{
	
	@Query (value= "SELECT * FROM perfil WHERE id_per = 1",  nativeQuery = true)
	public List<Perfil> lista();

}
