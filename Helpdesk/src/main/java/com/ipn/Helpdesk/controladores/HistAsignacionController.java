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

import com.ipn.Helpdesk.Servicios.HistAginacionService;

import com.ipn.Helpdesk.modelo.entidad.His_asignacion;

import com.ipn.Helpdesk.repositorios.His_asignacionRepository;

@RestController
@RequestMapping("/IPN/helpdesk/HistAsignacion/")
@CrossOrigin("*")
public class HistAsignacionController {

	@Autowired
	private HistAginacionService aginacionService;
	
	@Autowired
	private His_asignacionRepository asignacionRepository;

	@PostMapping("/")
	public ResponseEntity<His_asignacion> GuardarNuavaAsiganacion(@RequestBody His_asignacion asignacion) {
		His_asignacion asignacionAGuardar = aginacionService.AgregarAsignacion(asignacion);
		return ResponseEntity.ok(asignacionAGuardar);
	}

	@PutMapping("/")
	public His_asignacion ActulizarAsiganacio(@RequestBody His_asignacion asignacion) {
		{
			return aginacionService.ActilizarAsignacion(asignacion);
		}
	}
	
	@GetMapping("/{id_asignacion}")
	public His_asignacion ListaUnicaAsignacion  (@PathVariable ("id_asignacion") Long id_asignacion)
	{
		return aginacionService.ListarAsignacionUnica(id_asignacion);
	}
	
	@GetMapping ("/")
	public ResponseEntity<?> ListaTodasLasAsignaciones ()
	{
		return ResponseEntity.ok(aginacionService.ListarHistorialAsignaciones());
	}
	
	@DeleteMapping ("/{id_asignacion}")
	public void His_asignacion  (@PathVariable ("id_asignacion") Long id_asignacion) {
		aginacionService.EliminarAsigancion(id_asignacion);
	}
	
	
	@GetMapping ("/id_asignacion/{id_asignacion}")
	public ResponseEntity<?> ListaHistrialdeAsignacionDelTikcet (@PathVariable ("id_asignacion") Long id_asignacion)
	{
		return ResponseEntity.ok(asignacionRepository.ListaAsignaciondeTikcetIdTicket(id_asignacion));
	}
	

}
