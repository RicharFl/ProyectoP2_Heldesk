package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Ticket;

public interface TicketService {

	Ticket CrearTicket (Ticket ticket);
	
	Ticket ActualizarTicket (Ticket ticket);
	
	Set<Ticket> ListasTicket ();
	
	Ticket ListaTicketUnico (Long Id_empleado);
	
	void EliminarTicket (Long id_emplLong);
	
	
}
