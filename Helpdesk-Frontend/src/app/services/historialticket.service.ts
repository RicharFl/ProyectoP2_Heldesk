import { Subject } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class HistorialticketService {
  constructor(private http: HttpClient) { }


  public AgregarAlHistorial(histTciket:any){
    return this.http.post(`${baseUrl}/IPN/helpdesk/HistTicket/`,histTciket);
  }
  public ListaTodosLosHistorialesdeTicket() {
    return this.http.get(`${baseUrl}/IPN/helpdesk/HistTicket/`)
  }

  public ListaTodoselHistorialDeUnTicket(ticket:any) {
    return this.http.get(`${baseUrl}/IPN/helpdesk/HistTicket/id_ticket/${ticket.id_ticket}`, ticket.id_ticket)
  }

  public ActualizaElServicios(histTicket: any) {
    return this.http.put(`${baseUrl}/IPN/helpdesk/HistTicket/`, histTicket)
  }
}
