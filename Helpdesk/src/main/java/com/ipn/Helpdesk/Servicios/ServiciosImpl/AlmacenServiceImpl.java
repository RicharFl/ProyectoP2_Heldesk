package com.ipn.Helpdesk.Servicios.ServiciosImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.Helpdesk.Servicios.AlmacenService;
import com.ipn.Helpdesk.modelo.entidad.Almacen;
import com.ipn.Helpdesk.repositorios.AlmacenRepository;

@Service
public class AlmacenServiceImpl implements AlmacenService {

	@Autowired
	private AlmacenRepository almacenRepository;

	@Override
	public Almacen AgregarProducto(Almacen almacen) {

		return almacenRepository.save(almacen);
	}

	@Override
	public Almacen ActulizarStockProductos(Almacen almacen) {
		// TODO Auto-generated method stub
		return almacenRepository.save(almacen);
	}

	@Override
	public Set<Almacen> ListaProductosAlmacen() {

		return new LinkedHashSet<>(almacenRepository.findAll());
	}

	@Override
	public void EliminarProductos(Long Id_almacen) {

		Almacen almacenpro = new Almacen();
		almacenpro.setId_almacen(Id_almacen);
		almacenRepository.delete(almacenpro);
		//almacenRepository.deleteById(Id_almacen);
	}

	@Override
	public Almacen ObtenerProductoAlmacen(Long Id_almacen) {

		return almacenRepository.findById(Id_almacen).get();
	}

}
