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


  public ListaTicketsporZona (zona:any){
    return this.httpClient.get(`${baseUrl}/IPN/helpdesk/Ticket/tickeZona/${zona.username2}`,zona.username2)
  }

  public ListaMisTicketAsigandos (ticket_mios:any){
    return this.httpClient.get(`${baseUrl}/IPN/helpdesk/Ticket/tickeActivos/${ticket_mios.id_user}`, ticket_mios.id_user)
  }

  public ListaMisTicketcerrados (ticket_mios:any){
    return this.httpClient.get(`${baseUrl}/IPN/helpdesk/Ticket/tickeCerrados/${ticket_mios.id_user}`, ticket_mios.id_user)
  }
  public actualizaTicket (ticket:any){
    return this.httpClient.put(`${baseUrl}/IPN/helpdesk/Ticket/`,ticket)
  }

  public BuscaPorId_Ticket (ticket:any){
   // console.log ("este es el id "+ticket.id_ticket + " enpoind BuscaPorId_Ticket del ticketservice");
    return this.httpClient.get(`${baseUrl}/IPN/helpdesk/Ticket/${ticket.id_ticket}`,ticket.id_ticket)
  }

}
