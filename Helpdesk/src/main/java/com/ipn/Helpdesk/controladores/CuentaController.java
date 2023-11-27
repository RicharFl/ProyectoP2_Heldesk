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

import com.ipn.Helpdesk.Servicios.CuentaService;
import com.ipn.Helpdesk.modelo.entidad.Cuenta;

@RestController
@RequestMapping("/IPN/helpdesk/Cuenta/")
@CrossOrigin("*")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@PostMapping("/")
	public ResponseEntity<Cuenta> GuardarNuevaCuenta(@RequestBody Cuenta cuenta) {
		Cuenta CuentaAGuardar = cuentaService.AgregarCuenta(cuenta);
		return ResponseEntity.ok(CuentaAGuardar);

	}

	@GetMapping("/{id_cuenta}")

	public Cuenta ListaCuentaUnica(@PathVariable("id_cuenta") Long id_cuenta) {
		return cuentaService.ListaCuentaUnica(id_cuenta);

	}

	@PutMapping("/")
	public Cuenta ActulizarCuenta(@RequestBody Cuenta cuenta) {
		
		return cuentaService.actulizarCuenta(cuenta);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> ListaCUentas(){
		return ResponseEntity.ok(cuentaService.listarCuentas());
	}
	
	
	@DeleteMapping ("/{id_cuenta}")
	public void EliminarCuenta(@PathVariable ("id_cuenta") Long id_cuenta)
	{
		cuentaService.EliminarCuenta(id_cuenta);
	}
}
