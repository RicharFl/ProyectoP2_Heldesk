package com.ipn.Helpdesk.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ipn.Helpdesk.modelo.entidad.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

	
	
	@Query(value = "select *from ticket where id_ticket in ( select t.id_ticket from ticket t, usuarios u , his_asigancion h where   u.id_user=:iduser and t.id_status_ticket not in (5,6) and h.id_ticket = t.id_ticket and u.username = h.nameuser_final); ", nativeQuery = true)
	Set<Ticket> ListaMisTicketsAsigandosActivos (@Param ("iduser") Long iduser );
	
	@Query(value = "select *from ticket where id_ticket in ( select t.id_ticket from ticket t, usuarios u , his_asigancion h where   u.id_user=:iduser and t.id_status_ticket in (5,6) and h.id_ticket = t.id_ticket and u.username = h.nameuser_final);  ", nativeQuery = true)
	Set<Ticket> ListaMisTicketsCerradosYCancelados (@Param ("iduser") Long iduser );
	
	@Query(value = "select *from ticket where id_ticket in (select  t.id_ticket from ticket t ,estadosrepu e where t.id_est_repu= e.id_est_repu and id_zon = :idzon);  ", nativeQuery = true)
	Set<Ticket> ListaTicketsPorZona (@Param ("idzon") Long idzon );
}
