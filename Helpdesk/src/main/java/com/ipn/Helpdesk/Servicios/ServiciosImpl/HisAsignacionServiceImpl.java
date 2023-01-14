package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.HistAginacionService;
import com.ipn.Helpdesk.modelo.entidad.His_asignacion;
import com.ipn.Helpdesk.repositorios.His_asignacionRepository;

@Service
public class HisAsignacionServiceImpl implements HistAginacionService {

	@Autowired
	His_asignacionRepository asignacionRepository;

	@Override
	public His_asignacion ActilizarAsignacion(His_asignacion asignacion) {
		// TODO Auto-generated method stub
		return asignacionRepository.save(asignacion);
	}

	@Override
	public Set<His_asignacion> ListarHistorialAsignaciones() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(asignacionRepository.findAll());
	}

	@Override
	public His_asignacion ListarAsignacionUnica(Long id_asignacion) {
		// TODO Auto-generated method stub
		return asignacionRepository.findById(id_asignacion).get();
	}

	@Override
	public void EliminarAsigancion(Long id_asignacion) {

		His_asignacion asignacionEliminacion = new His_asignacion();
		asignacionEliminacion.setId_his_asignacion(id_asignacion);
		asignacionRepository.delete(asignacionEliminacion);

	}

	@Override
	public His_asignacion AgregarAsignacion(His_asignacion asignacion) {
		// TODO Auto-generated method stub
		return asignacionRepository.save(asignacion);
	}

}
