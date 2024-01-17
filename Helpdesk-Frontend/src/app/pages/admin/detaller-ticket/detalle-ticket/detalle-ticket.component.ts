import  Swal  from 'sweetalert2';
import { LoginService } from 'src/app/services/login.service';
import { HistorialticketService } from './../../../../services/historialticket.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { TicketService } from 'src/app/services/ticket.service';


@Component({
  selector: 'app-detalle-ticket',
  templateUrl: './detalle-ticket.component.html',
  styleUrls: ['./detalle-ticket.component.css']
})
export class DetalleTicketComponent implements OnInit{
  ticket: any = null;
  histrial_tiket:any=null;
  pagina!:number;
  ticket_data={
"id_ticket":'',
"des_error": ''
  }
  user:any=null;

  constructor(private tickets: TicketService, private route: ActivatedRoute, private router: Router,private historialTikcet:HistorialticketService,
    private login:LoginService) { }
  
  
  ngOnInit(): void {

    console.log(this.route.snapshot.params['idticket'] );

    if (this.route.snapshot.params['idticket'] != undefined) {
      this.ticket_data.id_ticket = this.route.snapshot.params['idticket'];     
    }
    else {
      this.router.navigate(['admin/ticket_admin']);
    }
    this.tickets.BuscaPorId_Ticket(this.ticket_data).subscribe(
      (data: any) => {
        this.ticket = data;
      },
      (error) => {
        alert("error");
      }
    )

    this.historialTikcet.ListaTodoselHistorialDeUnTicket(this.ticket_data).subscribe(
      (datahistorial: any) => {
        this.histrial_tiket = datahistorial;
        console.log(this.histrial_tiket.id_user);
      },
      (error) => {
        alert("error");
      }
    )

    console.log("Usuario con datos de Ticket");
 
    this.login.BuscaUsario(this.histrial_tiket.id_user).subscribe(
      (datauser: any) => {
     
        
        this.user = datauser;
        console.log(this.user);
      },
      (error) => {
        alert("error");
      }
    )



  }


  editarTicket (idticket:string)
{
  //console.log("esto es lo que mando desde admin_ticket");
//console.log("esto es lo que mando desde admin_ticket "+idticket);

if (this.login.getUser()=='1')
  {this.router.navigate(['admin/editar_ticket',idticket]);}
  else if (this.login.getUser()=='2')
  {this.router.navigate(['gerente_general/editar_ticket',idticket]);}
  else if (this.login.getUser()=='3')
  {this.router.navigate(['cordinador_zona/editar_ticket',idticket]);}
  else if (this.login.getUser()=='4')
  {this.router.navigate(['agente-mesa/editar_ticket',idticket]);}
  else if (this.login.getUser()=='5')
  {Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
  else if (this.login.getUser()=='6')
  {Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}

}


}
