package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Cuenta;

public interface CuentaService {

	Cuenta AgregarCuenta (Cuenta cuenta);
	
	Cuenta actulizarCuenta (Cuenta  cuenta);
	
	Set<Cuenta> listarCuentas();
	
	Cuenta ListaCuentaUnica (Long Id_cuenta);
	
	void EliminarCuenta (Long Id_cuenta);
}
