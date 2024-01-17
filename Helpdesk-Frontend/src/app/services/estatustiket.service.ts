import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
@Injectable({
  providedIn: 'root'
})
export class EstatustiketService {
  constructor(private http: HttpClient) { }


  
public ListaTodosLosEstatusdeTicket (){
  return this.http.get(`${baseUrl}/IPN/helpdesk/StatusTicket/`)
}




public ActulizaEstatusdeTciket (EstatusTicket:any)
{
  return this.http.put(`${baseUrl}/IPN/helpdesk/StatusTicket/`,EstatusTicket)
}

}
