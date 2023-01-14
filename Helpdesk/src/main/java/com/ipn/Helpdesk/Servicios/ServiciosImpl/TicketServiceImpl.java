package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.TicketService;
import com.ipn.Helpdesk.modelo.entidad.Ticket;
import com.ipn.Helpdesk.repositorios.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public Ticket CrearTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket ActualizarTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public Set<Ticket> ListasTicket() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(ticketRepository.findAll());
	}

	@Override
	public Ticket ListaTicketUnico(Long Id_empleado) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(Id_empleado).get();
	}

	@Override
	public void EliminarTicket(Long id_emplLong) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(id_emplLong);
	}

}
