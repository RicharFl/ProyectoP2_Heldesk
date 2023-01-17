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

import com.ipn.Helpdesk.Servicios.ClienteService;

import com.ipn.Helpdesk.modelo.entidad.Cliente;

@RestController
@RequestMapping("/IPN/helpdesk/Cliente/")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/")
	public ResponseEntity<Cliente> AgregarCliente(@RequestBody Cliente cliente) {
		Cliente agregarcliente= clienteService.AgregaCliente(cliente);
		return ResponseEntity.ok(agregarcliente);

	}
	@GetMapping("/")
	public ResponseEntity<?> ListaClientesCompletos (){
		return ResponseEntity.ok(clienteService.ListaClientes());
	}
	
	@GetMapping("/{id_cliente}")
	
	public Cliente ListaClienteUnico (@PathVariable("id_cliente") Long id_cliente)
	{
	return clienteService.ListaClienteUnico(id_cliente)	;
	}
	
	
	@PutMapping("/")
	public Cliente ActulizarCliente (@RequestBody Cliente clientee)
	{
		return clienteService.ActualizaCliente(clientee);
	}
	
	@DeleteMapping("/{id_cliente}")
	public void EliminaCuenta (@PathVariable ("id_cliente") Long id_cliente)
	{
		clienteService.EliminaCliente(id_cliente);
	}
	
	
	
	

	

}
