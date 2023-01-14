package com.ipn.Helpdesk.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ipn.Helpdesk.Servicios.EstadosRepuService;
import com.ipn.Helpdesk.modelo.entidad.EstadosRepu;

@RequestMapping("/IPN/helpdesk/EstadosRepublica")
@RestController
public class EstadosRepubController {

	@Autowired
	private EstadosRepuService estadosRepuService;

	@PostMapping("/")
	public ResponseEntity<EstadosRepu> GuardarNuevoEstadoRepublica(@RequestBody EstadosRepu estadosRepu) {
		EstadosRepu estadosRepAGuardar = estadosRepuService.AgregaEstadosRepublica(estadosRepu);
		return ResponseEntity.ok(estadosRepAGuardar);

	}

	@GetMapping("/{Id_estadoRepublica}")
	public EstadosRepu ListaUnicoEstado(@PathVariable("id_estadoRepublica") Long Id_estadoRepublica) {
		return estadosRepuService.listaEstadoRepublicaUnico(Id_estadoRepublica);

	}

	@PutMapping("/")
	public EstadosRepu ActulizarEstado(@RequestBody EstadosRepu estadosRepu) {
		return estadosRepuService.ActulizaEstadosRepublica(estadosRepu);
	}

	@GetMapping("/")

	public ResponseEntity<?> ListaTodosEstados() {
		return ResponseEntity.ok(estadosRepuService.ListaEstadosRepublica());
	}

	@DeleteMapping("/{Id_estadoRepublica}")

	public void EliminarEstadoRepublica(@PathVariable("Id_estadoRepublica") Long Id_estadoRepublica) {
		estadosRepuService.EliminaEstadosRepublica(Id_estadoRepublica);
	}

}
