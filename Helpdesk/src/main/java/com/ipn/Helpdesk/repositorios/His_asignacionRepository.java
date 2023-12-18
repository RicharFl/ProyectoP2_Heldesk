package com.ipn.Helpdesk.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipn.Helpdesk.modelo.entidad.His_asignacion;

@Repository
public interface His_asignacionRepository extends JpaRepository<His_asignacion, Long>{
	
	@Query(value = "select *from his_asigancion where id_ticket = :id_ticket", nativeQuery = true)
	Set<His_asignacion> ListaAsignaciondeTikcetIdTicket (@Param ("id_ticket") Long id_ticket);

}
