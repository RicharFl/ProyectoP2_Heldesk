import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private  httpClient: HttpClient ) { }

  public agrgarTicket (ticket:any)
  {
    return this.httpClient.post(`${baseUrl}/IPN/helpdesk/Ticket/`,ticket)
  }
  public listaTodosLosTickets (){
    return this.httpClient.get(`${baseUrl}/IPN/helpdesk/Ticket/`)
  }

  public actualizaTicket (ticket:any){
    return this.httpClient.put(`${baseUrl}/IPN/helpdesk/Ticket/`,ticket)
  }

  public BuscaPorId_Ticket (ticket:any){
    console.log ("este es el id:ticket en el endpond "+ticket.id_ticket);
    return this.httpClient.get(`${baseUrl}/IPN/helpdesk/Ticket/${ticket.id_ticket}`,ticket.id_ticket)
  }

}
