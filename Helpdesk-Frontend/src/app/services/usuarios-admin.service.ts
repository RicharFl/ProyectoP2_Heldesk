import { Subject } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';


@Injectable({
  providedIn: 'root'
})
export class UsuariosAdminService {

  public loginStatusSubjec = new Subject<boolean>();



  constructor(private http: HttpClient) { }



public listaTodosLosEmpleados (){
  return this.http.get(`${baseUrl}/IPN/helpdesk/Usuario/`)
}

public ActulizaDatosDeEmpleado (User:any)
{
  return this.http.put(`${baseUrl}/IPN/helpdesk/Usuario/`,User)
}

public ActulizaContrasena(User:any){
  return this.http.put(`${baseUrl}/IPN/helpdesk/Usuario/actulizar-Password/`,User)
}


}
