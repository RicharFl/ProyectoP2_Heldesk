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

import com.ipn.Helpdesk.Servicios.SlaTicketService;
import com.ipn.Helpdesk.modelo.entidad.Sla_ticket;

@RestController
@RequestMapping("/IPN/helpdesk/SLATicket/")
@CrossOrigin("*")
public class SlaTicketServiceController {

	@Autowired
	private SlaTicketService slaTicket;

	@PostMapping("/")
	public ResponseEntity<Sla_ticket> GuardaNuevoSLA(@RequestBody Sla_ticket sla_ticket) {
		Sla_ticket sla_ticket2 = slaTicket.AgregarSla(sla_ticket);
		return ResponseEntity.ok(sla_ticket2);
	}

	@PutMapping("/")
	public Sla_ticket ActulizarSLA(@RequestBody Sla_ticket sla_ticket) {
		return slaTicket.ActulizarSla(sla_ticket);
	}

	@GetMapping("/")
	public ResponseEntity<?> ListatodosLosSLA() {
		return ResponseEntity.ok(slaTicket.ListarSlas());
	}

	@GetMapping("/{id_Sla}")

	public Sla_ticket ListarslaPorId(@PathVariable("id_Sla") Long id_Sla) {
		return slaTicket.ListarSlaUnico(id_Sla);
	}
	
	@DeleteMapping("/{id_Sla}")

	public void eliminarSlaporId(@PathVariable("id_Sla") Long id_Sla) {
		 slaTicket.EliminarSla(id_Sla);
	}
	

}
