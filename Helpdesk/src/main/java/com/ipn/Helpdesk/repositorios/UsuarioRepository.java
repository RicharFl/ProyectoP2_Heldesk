package com.ipn.Helpdesk.repositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipn.Helpdesk.modelo.entidad.Usuarios;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> 
{

	public  Usuarios findByUsername(String usuername);

 
}
