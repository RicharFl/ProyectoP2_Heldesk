package com.ipn.Helpdesk.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ipn.Helpdesk.modelo.entidad.HisTicket;

@Repository
public interface HisTicketRepository extends JpaRepository<HisTicket, Long>{
	
	
	@Query(value = "select *from his_ticket where id_ticket = :id_ticket", nativeQuery = true)
	Set<HisTicket> ListaHistorialdeTikcetporIdTiket(@Param ("id_ticket") Long id_ticket );

}
