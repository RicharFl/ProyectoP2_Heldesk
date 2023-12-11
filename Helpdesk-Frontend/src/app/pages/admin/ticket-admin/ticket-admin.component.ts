import  Swal  from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketService } from 'src/app/services/ticket.service';
import { HistorialticketService } from 'src/app/services/historialticket.service';

 
@Component({
  selector: 'app-ticket-admin',
  templateUrl: './ticket-admin.component.html',
  styleUrls: ['./ticket-admin.component.css']
})
export class TicketAdminComponent implements OnInit {
ticket : any []
pagina!:number;


public ticket_AGuardar ={

  id_ticket: '',
  des_error: '',
  register_date: Date.now(),
  last_update_date: Date.now(),
  sla_status: '',
  cliente : {id_cliente: ''} ,
  estadosrepu: {id_est_repu:'' },
  servicios: {id_serv : ''},
    status_Ticket: {id_status_ticket: ''},
    usuarios:{id_user: ''}
 
}



constructor(private tickets: TicketService, private router:Router, private histTicketService: HistorialticketService) { }
ngOnInit(): void {
/*
  let dataclienteee = JSON.parse(localStorage.getItem ('dataHistorialTicket'));
 if ( dataclienteee == null   ){
  console.log("No hay inforacion");

 }
 else {
this.histTicketService.AgregarAlHistorial(dataclienteee).subscribe(
  (dato1:any) => {
        console.log("se guardo correctamente el registro");
        localStorage.removeItem('dataHistorialTicket')
  },
  (error)=>{
    console.log("EEROR EN GGUARDAR EL HISTORIA DE CREACCION");
    localStorage.removeItem('dataHistorialTicket')
  }

)
console.log(dataclienteee);

 }*/

  this.tickets.listaTodosLosTickets().subscribe(
    (dato:any) => {
      this.ticket = dato;
      console.log(this.ticket);
    },
    (error) => {
      console.log(error);
      Swal.fire('Error','Error al cargar los usaurios','error');
    }
  )

}

DetalleTicket (idticket:string)
{
  //console.log("esto es lo que mando desde admin_ticket");
//console.log("esto es lo que mando desde admin_ticket "+idticket);

  this.router.navigate(['admin/deetalle_ticket',idticket]);
}



DocTicket (idticket:string)
{
  //console.log("esto es lo que mando desde admin_ticket");
//console.log("esto es lo que mando desde admin_ticket "+idticket);

  this.router.navigate(['admin/documentar_ticket',idticket]);
}

editarTicket (idticket:string)
{
  //console.log("esto es lo que mando desde admin_ticket");
//console.log("esto es lo que mando desde admin_ticket "+idticket);

  this.router.navigate(['admin/editar_ticket',idticket]);
}


}