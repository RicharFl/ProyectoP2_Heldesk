package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.ClienteService;
import com.ipn.Helpdesk.modelo.entidad.Cliente;
import com.ipn.Helpdesk.repositorios.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente AgregaCliente(Cliente cliente) {

		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente ActualizaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	@Override
	public Set<Cliente> ListaClientes() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(clienteRepository.findAll());
	}

	@Override
	public Cliente ListaClienteUnico(Long Id_cliente) {

		return clienteRepository.findById(Id_cliente).get();
	}

	@Override
	public void EliminaCliente(Long Id_cliente) {

		Cliente Clienteeliminado = new Cliente();
		Clienteeliminado.setId_cliente(Id_cliente);
		clienteRepository.delete(Clienteeliminado);
	}

}
