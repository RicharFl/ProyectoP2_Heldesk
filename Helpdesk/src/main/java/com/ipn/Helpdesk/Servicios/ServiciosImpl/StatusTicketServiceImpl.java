package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.StatusTicketService;
import com.ipn.Helpdesk.modelo.entidad.Status_Ticket;
import com.ipn.Helpdesk.repositorios.StatusTicketRepository;
@Service
public class StatusTicketServiceImpl  implements StatusTicketService{
	
	@Autowired
	 private StatusTicketRepository repositoryStatus;

	@Override
	public Status_Ticket AgregarEstatus(Status_Ticket status_Ticket) {
		// TODO Auto-generated method stub
		return repositoryStatus.save(status_Ticket);
	}

	@Override
	public Status_Ticket ActulizarEstatus(Status_Ticket status_Ticket) {
		// TODO Auto-generated method stub
		return repositoryStatus.save(status_Ticket);
	}

	@Override
	public Set<Status_Ticket> ListaStutus() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(repositoryStatus.findAll()) ;
	}

	@Override
	public Status_Ticket ListaStatusUnico(Long Id_status) {
		// TODO Auto-generated method stub
		return repositoryStatus.findById(Id_status).get();
	}

	@Override
	public void EliminarStatus(Long Id_status) {
		// TODO Auto-generated method stub
		repositoryStatus.deleteById(Id_status);
	}

}
