package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.SlaTicketService;
import com.ipn.Helpdesk.modelo.entidad.Sla_ticket;
import com.ipn.Helpdesk.repositorios.SlaTiketRepository;

@Service
public class SlaTicketServiceImpl implements SlaTicketService {
	
	@Autowired
	private SlaTiketRepository repositorysla;

	@Override
	public Sla_ticket AgregarSla(Sla_ticket sla_ticket) {
		// TODO Auto-generated method stub
		return repositorysla.save(sla_ticket);
	}

	@Override
	public Sla_ticket ActulizarSla(Sla_ticket sla_ticket) {
		// TODO Auto-generated method stub
		return repositorysla.save(sla_ticket);
	}

	@Override
	public Set<Sla_ticket> ListarSlas() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(repositorysla.findAll());
	}

	@Override
	public Sla_ticket ListarSlaUnico(Long Id_sla) {
		// TODO Auto-generated method stub
		return repositorysla.findById(Id_sla).get();
	}

	@Override
	public void EliminarSla(Long id_sla) {
		repositorysla.deleteById(id_sla);
		
	}

	
}
