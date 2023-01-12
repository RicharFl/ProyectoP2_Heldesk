package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Sla_ticket;

public interface SlaTicketService {

	Sla_ticket AgregarSla(Sla_ticket sla_ticket);
	
	
	Sla_ticket ActulizarSla(Sla_ticket sla_ticket);
	
	Set<Sla_ticket> ListarSlas ();
	
	Sla_ticket ListarSlaUnico(Long Id_sla);
	
	void EliminarSla (Long id_sla);
	
	
}
