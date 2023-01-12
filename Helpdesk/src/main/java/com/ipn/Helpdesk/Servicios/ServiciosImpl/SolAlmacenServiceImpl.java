package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.SolAlmacenService;
import com.ipn.Helpdesk.modelo.entidad.Sol_Alm;
import com.ipn.Helpdesk.repositorios.Sol_AlmRepository;
@Service
public class SolAlmacenServiceImpl implements SolAlmacenService{
	
	@Autowired
	private Sol_AlmRepository almRepository; 
	

	@Override
	public Sol_Alm AgregarSolicitudAlmacen(Sol_Alm alm) {
		// TODO Auto-generated method stub
		return almRepository.save(alm) ;
	}

	@Override
	public Sol_Alm ActualizarSolicitudAlmacen(Sol_Alm alm) {
		// TODO Auto-generated method stub
		return almRepository.save(alm) ;
	}

	@Override
	public Set<Sol_Alm> ListaSolicitudes() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(almRepository.findAll());
	}

	@Override
	public Sol_Alm ListaSolicitudUnica(Long Id_solicitud_almacen) {
		// TODO Auto-generated method stub
		return almRepository.findById(Id_solicitud_almacen).get();
	}

	@Override
	public void EliminarSolicitud(Long Id_solicitud_almacen) {
	
		almRepository.deleteById(Id_solicitud_almacen);
	}

}
