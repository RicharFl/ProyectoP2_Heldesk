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

import com.ipn.Helpdesk.Servicios.AlmacenService;
import com.ipn.Helpdesk.modelo.entidad.Almacen;

@RestController
@RequestMapping("/IPN/helpdesk/Almacen/")
@CrossOrigin("*")
public class AlmacenController {

	@Autowired
	private AlmacenService almacenService;

  	@PostMapping("/") // PARA GUARDO UN PRODUCTO
	public ResponseEntity<Almacen> AgregarProductoAlmacen(@RequestBody Almacen almacen) {
		Almacen agregarproductoalmacen = almacenService.AgregarProducto(almacen);
		return ResponseEntity.ok(agregarproductoalmacen);

	}
	
	@GetMapping ("/")
	public ResponseEntity<?> ListaProductosAlmacen ()
	{
		return ResponseEntity.ok(almacenService.ListaProductosAlmacen());
	}

	@GetMapping("/{id_almacen}")

	public Almacen ListaProductosAlmacenPorId(@PathVariable("id_almacen") Long Id_almacen) {
		return almacenService.ObtenerProductoAlmacen(Id_almacen);

	}

	@PutMapping("/")
	public Almacen ActulizarProductoAlmacen(@RequestBody Almacen almacen) {
		return almacenService.ActulizarStockProductos(almacen);
	}
	
	@DeleteMapping("/{id_almacen}")
	public void EliminarProductoAlmacen (@PathVariable("id_almacen") Long Id_almacen)
	{
		almacenService.EliminarProductos(Id_almacen);
	}

}
