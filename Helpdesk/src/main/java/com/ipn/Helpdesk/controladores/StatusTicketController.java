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

import com.ipn.Helpdesk.Servicios.StatusTicketService;
import com.ipn.Helpdesk.modelo.entidad.Status_Ticket;

@RestController
@RequestMapping("/IPN/helpdesk/StatusTicket/")
@CrossOrigin("*")
public class StatusTicketController {
	@Autowired
	private StatusTicketService statusTicketService;

	@PostMapping("/")
	public ResponseEntity<Status_Ticket> GuardarNuevoStatusTicket(@RequestBody Status_Ticket status_Ticket) {
		Status_Ticket status_Ticket2 = statusTicketService.AgregarEstatus(status_Ticket);
		return ResponseEntity.ok(status_Ticket2);
	}

	@PutMapping("/")
	public Status_Ticket ActulizarStausTicket(@RequestBody Status_Ticket status_Ticket) {
		return statusTicketService.ActulizarEstatus(status_Ticket);
	}

	@GetMapping("/")

	public ResponseEntity<?> ListaTodosLosStatus() {
		return ResponseEntity.ok(statusTicketService.ListaStutus());
	}

	@GetMapping("/{id_stausTicket}")
	public Status_Ticket ListarStatusPorId(@PathVariable ("id_stausTicket") Long id_stausTicket)
	{
		return statusTicketService.ListaStatusUnico(id_stausTicket);
	}
	
	@DeleteMapping("/{id_stausTicket}")
	public void EliminaStatusPorId(@PathVariable ("id_stausTicket") Long id_stausTicket)
	{
		statusTicketService.EliminarStatus(id_stausTicket);
	}
}
