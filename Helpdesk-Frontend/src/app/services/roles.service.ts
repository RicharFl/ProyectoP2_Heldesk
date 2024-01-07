import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class RolesService {

  constructor(private http: HttpClient) { }

  
  public ListaTodosLosRoles() {
    return this.http.get(`${baseUrl}/IPN/helpdesk/perfil/`)
  }

  public ActualizaElRol(Rol: any) {
    return this.http.put(`${baseUrl}/IPN/helpdesk/perfil/`, Rol)
  }
  public CreaRol(Rol: any) {
    return this.http.post(`${baseUrl}/IPN/helpdesk/perfil/`, Rol)
  }

  public ListaRolporID(Rol: any) {
    return this.http.get(`${baseUrl}/IPN/helpdesk/perfil/${Rol.id_per}`, Rol.id_per)
  }
}
