package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.EstadosRepu;

public interface EstadosRepuService {

	EstadosRepu AgregaEstadosRepublica(EstadosRepu estadosRepu);
	
	EstadosRepu ActulizaEstadosRepublica(EstadosRepu estadosRepu);
	
	Set<EstadosRepu> ListaEstadosRepublica();
	
	EstadosRepu listaEstadoRepublicaUnico(Long Id_estado_repu);
	
	void EliminaEstadosRepublica(Long Id_estado_repu);
	
	
}
