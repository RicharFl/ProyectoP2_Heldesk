import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class AsignarTicketService {

  constructor(private http: HttpClient) { }


  
public ListaTodolosHistorialesDeAsigncion (){
  return this.http.get(`${baseUrl}/IPN/helpdesk/HistAsignacion/`)
}

public ListaHistorialdeAsignacionPorTicketPorIdTicket (asignacion:any)
{
  return this.http.get(`${baseUrl}/IPN/helpdesk/HistAsignacion/`)
}


public añadirAsignacion(hisasignacion:any){
  return this.http.post(`${baseUrl}/IPN/helpdesk/HistAsignacion/`,hisasignacion);
}

}
