package com.ipn.Helpdesk.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipn.Helpdesk.modelo.entidad.Status_Ticket;

@Repository
public interface StatusTicketRepository extends JpaRepository<Status_Ticket, Long>{

}
