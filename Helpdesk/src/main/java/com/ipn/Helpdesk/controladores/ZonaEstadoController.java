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

import com.ipn.Helpdesk.Servicios.ZonaEstadosService;
import com.ipn.Helpdesk.modelo.entidad.ZonaEstados;

@RestController
@RequestMapping("/IPN/helpdesk/ZonaEstado/")
@CrossOrigin("*")
public class ZonaEstadoController {
	
	@Autowired
	private ZonaEstadosService zonaEstadosService;
	
	@PostMapping("/")
	public ResponseEntity<ZonaEstados> CrearNuevaZona(@RequestBody ZonaEstados estados)
	{
		ZonaEstados estados2 = zonaEstadosService.CrearNuevaZona(estados);
		return ResponseEntity.ok(estados2);
	}

	@PutMapping("/")
	public ZonaEstados ActulizarZonaEstado(@RequestBody ZonaEstados estados)
	{
		return zonaEstadosService.ActulizarZonaEstado(estados);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<?> ListaTodasZonasEstados()
	{
		return ResponseEntity.ok(zonaEstadosService.ListarTodasLasZonasEstados());
	}
	
	@GetMapping("/{id_zona}")
	public ZonaEstados ListaZonaPorId (@PathVariable ("id_zona") Long Id_zona)
	{
		return zonaEstadosService.ListarZonaEstadoUnica(Id_zona);
	}
	
	@DeleteMapping ("/{id_zona}")
	public void EliminaZonaPorId (@PathVariable ("id_zona") Long Id_zona)
	{
		 zonaEstadosService.EliminarZona(Id_zona);
	}
}
