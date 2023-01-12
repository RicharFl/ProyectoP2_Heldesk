package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.HisTicket;

public interface HisTicketService {

	HisTicket AgregarHistorialTicket(HisTicket hisTicket);
	
	HisTicket ActualizarHistorialTicket(HisTicket hisTicket);
	
	Set<HisTicket> ListarHistorialesTickes();
	
	HisTicket AgregarHistorialTicket(Long Id_histTicket);
	
	void EliminarHistorialTicket(Long Id_histTicket);
	
	
}
