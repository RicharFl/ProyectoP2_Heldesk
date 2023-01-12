package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Cliente;

public interface ClienteService {

	Cliente AgregaCliente (Cliente cliente);
	
	Cliente ActualizaCliente (Cliente cliente);
	
	Set<Cliente> ListaClientes();
	
	Cliente ListaClienteUnico(Long Id_cliente);
	
	void EliminaCliente (Long Id_cliente);
	
}
