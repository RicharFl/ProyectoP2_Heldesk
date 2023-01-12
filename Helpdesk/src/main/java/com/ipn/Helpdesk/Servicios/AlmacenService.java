package com.ipn.Helpdesk.Servicios;

import java.util.Set;

import com.ipn.Helpdesk.modelo.entidad.Almacen;

public interface AlmacenService {
	
	Almacen AgregarProducto (Almacen almacen);
	
	Almacen ActulizarStockProductos (Almacen almacen);
	
	Set<Almacen> ListaProductosAlmacen ();
	
	void EliminarProductos (Long Id_almacen);
	
	Almacen ObtenerProductoAlmacen (Long Id_almacen);
	

}
