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

import com.ipn.Helpdesk.Servicios.SolAlmacenService;
import com.ipn.Helpdesk.modelo.entidad.Sol_Alm;

@RestController
@RequestMapping("/IPN/helpdesk/SolicitudAlmacen/")
@CrossOrigin("*")
public class SolAlmacenController {
	@Autowired
	private SolAlmacenService almacenService;

	@PostMapping("/")
	public ResponseEntity<Sol_Alm> GuardarSolicitudAlmacen(@RequestBody Sol_Alm alm) {
		Sol_Alm alm2 = almacenService.AgregarSolicitudAlmacen(alm);
		return ResponseEntity.ok(alm2);
	}

	@PutMapping("/")
	public Sol_Alm ActualizarSolicituddeAlmacen(@RequestBody Sol_Alm alm) {
		return almacenService.ActualizarSolicitudAlmacen(alm);
	}

	@GetMapping("/")
	public ResponseEntity<?> ListarTodasLasSolicitudes() {
		return ResponseEntity.ok(almacenService.ListaSolicitudes());
	}

	@GetMapping("/{id_solicitudAlmacen}")
	public Sol_Alm ListaPorIdAlmacen(@PathVariable("id_solicitudAlmacen") Long id_solicitudAlmacen) {
		return almacenService.ListaSolicitudUnica(id_solicitudAlmacen);
	}
	
	
	@DeleteMapping ("/{id_solicitudAlmacen}")
	public void EliminarPorIdAlmacen(@PathVariable("id_solicitudAlmacen") Long id_solicitudAlmacen) {
		 almacenService.EliminarSolicitud(id_solicitudAlmacen);
	}
	
	
	 
	
}
