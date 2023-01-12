package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Status_Ticket;

public interface StatusTicketService {

	Status_Ticket AgregarEstatus (Status_Ticket status_Ticket);
	
	Status_Ticket ActulizarEstatus (Status_Ticket status_Ticket);
	
	Set<Status_Ticket> ListaStutus ();
	
	Status_Ticket ListaStatusUnico (Long Id_status);
	
	void EliminarStatus (Long Id_status);
	
	
}
