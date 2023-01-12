package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Sol_Alm;

public interface SolAlmacenService {
	
	Sol_Alm AgregarSolicitudAlmacen(Sol_Alm alm);
	
	Sol_Alm ActualizarSolicitudAlmacen(Sol_Alm alm);
	
	Set<Sol_Alm> ListaSolicitudes ();
	
	Sol_Alm ListaSolicitudUnica(Long Id_solicitud_almacen);
	
	void EliminarSolicitud(Long Id_solicitud_almacen);
	
	

}
