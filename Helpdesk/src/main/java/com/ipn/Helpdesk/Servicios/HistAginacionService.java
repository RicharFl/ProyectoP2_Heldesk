package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.His_asignacion;

public interface HistAginacionService {

	His_asignacion ActilizarAsignacion (His_asignacion asignacion);
	
	Set<His_asignacion> ListarHistorialAsignaciones();
	
	His_asignacion ListarAsignacionUnica (Long id_asignacion);
	
	void EliminarAsigancion (Long id_asignacion);
}
