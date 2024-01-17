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

import com.ipn.Helpdesk.Servicios.ServiciosService;
import com.ipn.Helpdesk.modelo.entidad.Servicios;

@RequestMapping("/IPN/helpdesk/Servicios/")
@RestController
@CrossOrigin("*")
public class ServiciosController {

	@Autowired
	private ServiciosService serviceSer;

	@PostMapping("/")
	public ResponseEntity<Servicios> GuardarNuevoServicio(@RequestBody Servicios servicios) {
		Servicios servicios2 = serviceSer.AgregarServicio(servicios);
		return ResponseEntity.ok(servicios2);
	}

	@PutMapping("/")
	public Servicios ActlizarServicios(@RequestBody Servicios servicios) {
		return serviceSer.ActulizarServicio(servicios);
	}

	@GetMapping("/")
	public ResponseEntity<?> ListaTodosLosServicios() {

		return ResponseEntity.ok(serviceSer.ListaServios());
	}
	
	@GetMapping("/{id_servicio}")
	public Servicios ListarServicioPorid(@PathVariable ("id_servicio") Long id_servicio)
	{
		return serviceSer.ListaServicioUnico(id_servicio);
	}

	@DeleteMapping("/{id_servicio}")
	public void eliminarServicio(@PathVariable ("id_servicio") Long id_servicio)
	{
		serviceSer.EliminarServicio(id_servicio);
	}
}
