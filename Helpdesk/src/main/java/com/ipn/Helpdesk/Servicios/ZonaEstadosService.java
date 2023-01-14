package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.ZonaEstados;

public interface ZonaEstadosService {

	ZonaEstados CrearNuevaZona(ZonaEstados estados);
	
	ZonaEstados ActulizarZonaEstado(ZonaEstados estados);
	
	Set<ZonaEstados> ListarTodasLasZonasEstados();
	
	void EliminarZona(Long id_zonaEstados);
	
	ZonaEstados ListarZonaEstadoUnica(Long Id_zonaEstado);
}
