package com.ipn.Helpdesk.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.Servicios.TicketService;
import com.ipn.Helpdesk.modelo.entidad.Ticket;
import com.ipn.Helpdesk.repositorios.TicketRepository;

import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/IPN/helpdesk/Ticket/")
@CrossOrigin("*")
public class TciketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketRepository repository;
	
	@PostMapping ("/")
	public ResponseEntity<Ticket> GuardarNuevoTicket(@RequestBody Ticket ticket)
	{
	Ticket ticketGuardar = ticketService.CrearTicket(ticket);
	return ResponseEntity.ok(ticketGuardar);
	}
	
	@PutMapping("/")
	public Ticket actulizarTicket (@RequestBody Ticket ticket) {
		return ticketService.ActualizarTicket(ticket);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> ListaTodosLosTicket()
	{
	return ResponseEntity.ok(ticketService.ListasTicket());	
	}
	
	@GetMapping("/{id_ticket}")
	public Ticket ListaTicketPorId( @PathVariable ("id_ticket") Long id_ticket)
	{
		return ticketService.ListaTicketUnico(id_ticket);
	}
	
	@GetMapping("/tickeActivos/{iduser}")
	public ResponseEntity<?>  ListaMisTicketsAsignados( @PathVariable ("iduser") Long iduser)
	{
		return ResponseEntity.ok(repository.ListaMisTicketsAsigandosActivos(iduser));
	}
	
	
	
	@GetMapping("/tickeCerrados/{iduser}")
	public ResponseEntity<?>  ListaMisTicketsCerrados( @PathVariable ("iduser") Long iduser)
	{
		return ResponseEntity.ok(repository.ListaMisTicketsCerradosYCancelados(iduser));
	}
	 
	

	@GetMapping("/tickeZona/{iduser}")
	public ResponseEntity<?>  ListaTickestPorZonaAsignada( @PathVariable ("iduser") Long iduser)
	{
		return ResponseEntity.ok(repository.ListaTicketsPorZona(iduser));
	}
	@DeleteMapping("/{id_ticket}")
	public void EliminarTicketPorId( @PathVariable ("id_ticket") Long id_ticket)
	{
		 ticketService.EliminarTicket(id_ticket);
	}	
	
}
