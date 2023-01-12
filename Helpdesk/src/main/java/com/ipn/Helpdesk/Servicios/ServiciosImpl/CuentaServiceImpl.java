package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.CuentaService;
import com.ipn.Helpdesk.modelo.entidad.Cuenta;
import com.ipn.Helpdesk.repositorios.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	public Cuenta AgregarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return cuentaRepository.save(cuenta);
	}

	@Override
	public Cuenta actulizarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return cuentaRepository.save(cuenta);
	}

	@Override
	public Set<Cuenta> listarCuentas() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(cuentaRepository.findAll());
	}

	@Override
	public Cuenta ListaCuentaUnica(Long Id_cuenta) {
		// TODO Auto-generated method stub
		return cuentaRepository.findById(Id_cuenta).get();
	}

	@Override
	public void EliminarCuenta(Long Id_cuenta) {

		Cuenta cuentaeliminada = new Cuenta();
		cuentaeliminada.setId_cuen(Id_cuenta);
		cuentaRepository.delete(cuentaeliminada);
	}

}
