import { Subject } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }



  public ListaTodosLosClientes() {
    return this.http.get(`${baseUrl}/IPN/helpdesk/Cliente/`)
  }

  public ActualizaElCliente(cliente: any) {
    return this.http.put(`${baseUrl}/IPN/helpdesk/Cliente/`, cliente)
  }

  public CrearElCliente(cliente: any) {
    return this.http.post(`${baseUrl}/IPN/helpdesk/Cliente/`, cliente)
  }
  
  public ListaClientesId(cliente: any) {
    return this.http.get(`${baseUrl}/IPN/helpdesk/Cliente/${cliente.id_cliente}`, cliente.id_cliente)
  }
}
