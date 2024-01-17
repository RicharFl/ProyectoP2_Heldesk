import { LoginService } from 'src/app/services/login.service';
import { ClienteService } from './../../../../services/cliente.service';
import { ServiciosService } from './../../../../services/servicios.service';
import { EstatustiketService } from './../../../../services/estatustiket.service';
import { EstadosrepublicaService } from './../../../../services/estadosrepublica.service';
import { ZonaestadosService } from './../../../../services/zonaestados.service';
import { TicketService } from 'src/app/services/ticket.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-ticket',
  templateUrl: './editar-ticket.component.html',
  styleUrls: ['./editar-ticket.component.css']
})
export class EditarTicketComponent implements OnInit {


  constructor(private route: ActivatedRoute, private router: Router, private ticketservice: TicketService,
    private estadosRepublica: EstadosrepublicaService, private EstTicket: EstatustiketService, private servicios: ServiciosService,
    private clientes:ClienteService, private loginser:LoginService) { }
  ticket: any = null;
  EstadosRepublicas: any = null;
  EstatusTicket: any = null;
  Servicio: any = null;
  Cliente: any = null;

  snack: any;
  ticket_data = {
    "id_ticket": '',
    "des_error": ''
  }
  ngOnInit(): void {

    // console.log(this.route.snapshot.params['idticket'] );

    if (this.route.snapshot.params['idticket'] != undefined) {
      this.ticket_data.id_ticket = this.route.snapshot.params['idticket'];
    }
    else {
      this.router.navigate(['admin/ticket_admin']);
    }
    this.ticketservice.BuscaPorId_Ticket(this.ticket_data).subscribe(
      (data: any) => {
        this.ticket = data;
      },
      (error) => {
        alert("error");
      }
    )

    this.estadosRepublica.ListaTodosLosEstadosDelaRepublica().subscribe(
      (dataestados: any) => {
        this.EstadosRepublicas = dataestados;
      },
      (error) => {
        alert("error");
      }

    )



    this.EstTicket.ListaTodosLosEstatusdeTicket().subscribe(
      (dataestTicket: any) => {
        this.EstatusTicket = dataestTicket;
      },
      (error) => {
        alert("error");
      }

    )

    this.servicios.ListaTodosLosServicios().subscribe(
      (dataServicios: any) => {
        this.Servicio = dataServicios;
      },
      (error) => {
        alert("error");
      }

    )

    this.clientes.ListaTodosLosClientes().subscribe(
      (dataCliente: any) => {
        this.Cliente = dataCliente;
      },
      (error) => {
        alert("error");
      }

    )






  }
  onSubmit(): void {

    this.ticket.last_update_date = Date.now();

    this.ticketservice.actualizaTicket(this.ticket).subscribe(
      (data) => {
        //console.log(data);
        Swal.fire('Ticket Actulizado', 'Ticket actizado exito en el sistema', 'success');
        
      if (this.loginser.getUser()=='1')
      {this.router.navigate(['admin/ticket_admin']);}
      else if (this.loginser.getUser()=='2')
      { //Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');
        this.router.navigate(['gerente_general/ticket_admin']);
      }
      else if (this.loginser.getUser()=='3')
      {this.router.navigate(['cordinador_zona/ticket_admin']);}
      else if (this.loginser.getUser()=='4')
      {this.router.navigate(['agente-mesa/ticket_admin']);}
      else if (this.loginser.getUser()=='5')
      {this.router.navigate(['tecnico_especialista/ticket_admin']);}
      else if (this.loginser.getUser()=='6')
      {this.router.navigate(['almacen/ticket_admin']);}


      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )
  }


  salir()
  {
    if (this.loginser.getUser()=='1')
    {this.router.navigate(['admin/ticket_admin']);}
    else if (this.loginser.getUser()=='2')
    { //Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');
      this.router.navigate(['gerente_general/ticket_admin']);
    }
    else if (this.loginser.getUser()=='3')
    {this.router.navigate(['cordinador_zona/ticket_admin']);}
    else if (this.loginser.getUser()=='4')
    {this.router.navigate(['agente-mesa/ticket_admin']);}
    else if (this.loginser.getUser()=='5')
    {this.router.navigate(['tecnico_especialista/ticket_admin']);}
    else if (this.loginser.getUser()=='6')
    {this.router.navigate(['almacen/ticket_admin']);}
  
  }

}
