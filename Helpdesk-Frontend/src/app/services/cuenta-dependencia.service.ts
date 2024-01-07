import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CuentaDependenciaService {

  constructor(private http: HttpClient) { }

  
  public ListaTodasCuentasDependencias() {
    return this.http.get(`${baseUrl}/IPN/helpdesk/Cuenta/`)
  }

  public ActualizaCuentasDependencias(cuenta: any) {
    return this.http.put(`${baseUrl}/IPN/helpdesk/Cuenta/`, cuenta)
  }
  public CreaCuentasDependencias(cuenta: any) {
    return this.http.post(`${baseUrl}/IPN/helpdesk/Cuenta/`, cuenta)
  }

  public ListaCuentasDependenciasId(cuenta: any) {
    return this.http.get(`${baseUrl}/IPN/helpdesk/Cuenta/${cuenta.id_cuen}`, cuenta.id_cuen)
  }
}
