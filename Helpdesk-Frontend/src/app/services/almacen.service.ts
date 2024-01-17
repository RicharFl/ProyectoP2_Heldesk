import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class AlmacenService {

  
  constructor(private http: HttpClient) { }



  public ListaTodoselAlmacen() {
    return this.http.get(`${baseUrl}/IPN/helpdesk/Almacen/`)
  }

  public ActualizaElAlmacen(almacen: any) {
    return this.http.put(`${baseUrl}/IPN/helpdesk/Almacen/`, almacen)
  }

  public CrearProductoAlmacen(almacen: any) {
    return this.http.post(`${baseUrl}/IPN/helpdesk/Almacen/`, almacen)
  }
  
  public ListaAlmacenId(almacen: any) {
    return this.http.get(`${baseUrl}/IPN/helpdesk/Almacen/${almacen.id_almacen}`, almacen.id_almacen)
  }
}
