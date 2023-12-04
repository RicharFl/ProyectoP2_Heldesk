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

import com.ipn.Helpdesk.Servicios.HisTicketService;
import com.ipn.Helpdesk.modelo.entidad.HisTicket;
import com.ipn.Helpdesk.repositorios.HisTicketRepository;

@RestController
@RequestMapping("/IPN/helpdesk/HistTicket/")
@CrossOrigin("*")
public class HistTicketController {

	@Autowired
	private HisTicketService hisTicketService;
	
	@Autowired
	private HisTicketRepository hisTicketRepository;

	@PostMapping("/")

	public ResponseEntity<HisTicket> GuardarHistorialdeTicket(@RequestBody HisTicket hisTicket) {
		HisTicket hisTicket2 = hisTicketService.AgregarHistorialTicket(hisTicket);
		return ResponseEntity.ok(hisTicket2);
	}
	
	@PutMapping("/")
	public HisTicket ActulizarHistorialdeTicket (@RequestBody HisTicket hisTicket)
	{
		return hisTicketService.ActualizarHistorialTicket(hisTicket);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> ListaHistorialesdeTickets(){
		return ResponseEntity.ok(hisTicketService.ListarHistorialesTickes());
	}
	
	@GetMapping("/id_ticket/{id_ticket}")
	public ResponseEntity<?> ListaHistorialdeTikcet(@PathVariable ("id_ticket") Long id_ticket){
		return ResponseEntity.ok(hisTicketRepository.ListaHistorialdeTikcetporIdTiket(id_ticket));
	}
	
	
	@DeleteMapping ("/{id_historialTicket}")
	public void eliminarHistialTicketporID(@PathVariable ("id_historialTicket") Long id_historialTicket )
	{
		hisTicketService.EliminarHistorialTicket(id_historialTicket);
	}
	
}
