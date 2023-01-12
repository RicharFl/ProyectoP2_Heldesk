package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.ServiciosService;
import com.ipn.Helpdesk.modelo.entidad.Servicios;
import com.ipn.Helpdesk.repositorios.ServiciosRepository;
@Service
public class ServiciosServiceImpl implements ServiciosService {

	@Autowired
	private ServiciosRepository serviciosRepository;
	
	@Override
	public Servicios AgregarServicio(Servicios servicios) {
		// TODO Auto-generated method stub
		return serviciosRepository.save(servicios);
	}

	@Override
	public Servicios ActulizarServicio(Servicios servicios) {
		// TODO Auto-generated method stub
		return serviciosRepository.save(servicios);
	}

	@Override
	public Set<Servicios> ListaServios() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(serviciosRepository.findAll());
	}

	@Override
	public Servicios ListaServicioUnico(Long id_servicio) {
		// TODO Auto-generated method stub
		return serviciosRepository.findById(id_servicio).get();
	}

	@Override
	public void EliminarServicio(Long Id_servicio) {
		Servicios serviciosEliminado  = new Servicios();
		serviciosEliminado.setId_serv(Id_servicio);
		serviciosRepository.delete(serviciosEliminado);
		
	}

}
