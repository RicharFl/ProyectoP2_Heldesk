package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.EstadosRepuService;
import com.ipn.Helpdesk.modelo.entidad.EstadosRepu;
import com.ipn.Helpdesk.repositorios.EstadosRepuRepository;

@Service
public class EstadosRepuServiceImpl implements EstadosRepuService {
	@Autowired
	private EstadosRepuRepository estadosRepuRepository;

	@Override
	public EstadosRepu AgregaEstadosRepublica(EstadosRepu estadosRepu) {
		// TODO Auto-generated method stub
		return estadosRepuRepository.save(estadosRepu);
	}

	@Override
	public EstadosRepu ActulizaEstadosRepublica(EstadosRepu estadosRepu) {
		// TODO Auto-generated method stub
		return estadosRepuRepository.save(estadosRepu);
	}

	@Override
	public Set<EstadosRepu> ListaEstadosRepublica() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(estadosRepuRepository.findAll());
	}

	@Override
	public EstadosRepu listaEstadoRepublicaUnico(Long Id_estado_repu) {
		// TODO Auto-generated method stub
		return estadosRepuRepository.findById(Id_estado_repu).get();
	}

	@Override
	public void EliminaEstadosRepublica(Long Id_estado_repu) {
		// TODO Auto-generated method stub
		EstadosRepu estadosRepuEliminado = new EstadosRepu();
		estadosRepuEliminado.setId_est_repu(Id_estado_repu);
		estadosRepuRepository.delete(estadosRepuEliminado);
	}

}
