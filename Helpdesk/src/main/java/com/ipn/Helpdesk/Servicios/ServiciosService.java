package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Servicios;

public interface ServiciosService {

	Servicios AgregarServicio (Servicios servicios);
	
	Servicios ActulizarServicio(Servicios servicios);
	
	Set<Servicios> ListaServios  ();
	
	Servicios ListaServicioUnico (Long id_servicio);
	
	void EliminarServicio (Long Id_servicio);
	
	
}
