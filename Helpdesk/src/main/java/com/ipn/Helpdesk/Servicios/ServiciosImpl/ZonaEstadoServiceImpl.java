package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.ZonaEstadosService;
import com.ipn.Helpdesk.modelo.entidad.ZonaEstados;
import com.ipn.Helpdesk.repositorios.ZonaEstadosRepository;

@Service
public class ZonaEstadoServiceImpl implements ZonaEstadosService {

	@Autowired
	private ZonaEstadosRepository estadosRepository;
	@Override
	public ZonaEstados CrearNuevaZona(ZonaEstados estados) {
		return estadosRepository.save(estados);
	}

	@Override
	public ZonaEstados ActulizarZonaEstado(ZonaEstados estados) {
		// TODO Auto-generated method stub
		return estadosRepository.save(estados);
	}

	@Override
	public Set<ZonaEstados> ListarTodasLasZonasEstados() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(estadosRepository.findAll());
	}

	@Override
	public void EliminarZona(Long id_zonaEstados) {
		estadosRepository.deleteById(id_zonaEstados);
		
	}

	@Override
	public ZonaEstados ListarZonaEstadoUnica(Long Id_zonaEstado) {
		// TODO Auto-generated method stub
		return estadosRepository.findById(Id_zonaEstado).get();
	}

}
