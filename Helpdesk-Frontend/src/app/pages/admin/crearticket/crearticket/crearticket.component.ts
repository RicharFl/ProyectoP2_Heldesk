import { AsignarTicketService } from './../../../../services/asignar-ticket.service';
import { HistorialticketService } from './../../../../services/historialticket.service';
import Swal from 'sweetalert2';
import { LoginService } from './../../../../services/login.service';
import { ClienteService } from './../../../../services/cliente.service';
import { ServiciosService } from './../../../../services/servicios.service';
import { EstatustiketService } from './../../../../services/estatustiket.service';
import { EstadosrepublicaService } from './../../../../services/estadosrepublica.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TicketService } from 'src/app/services/ticket.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crearticket',
  templateUrl: './crearticket.component.html',
  styleUrls: ['./crearticket.component.css']
})
export class CrearticketComponent implements OnInit {

  constructor(private ticketService: TicketService, private snack: MatSnackBar, private router: Router, private estadosRepublica: EstadosrepublicaService, private EstTicket: EstatustiketService,
    private servicios: ServiciosService,
    private clientes: ClienteService, private loginService: LoginService, 
    private histTicket: HistorialticketService, private asignacion : AsignarTicketService) { };
  public dataTicket = {

    des_error: '',
    estadosrepu: { id_est_repu: '' },
    usuarios: { id_user: '' },
    servicios: { id_serv: '' },
    cliente: { id_cliente: '' },
    status_Ticket: { id_status_ticket: '' },
    sla_status: 'En tiempo',
    no_serie: '',
    register_date: Date.now(),
    last_update_date: Date.now()
  }


  public dataHistorialTicket = {

    ticket: { id_ticket: 0 },
    username: '',
    comentario: '',
    fec_inicio: Date.now(),
    sla_status_hist: 0,
    register_date: Date.now(),
    last_update_date: Date.now()
  
  }


  public data2 = {
    id_ticket: 0,
    des_error: '',
    estadosrepu: { id_est_repu: '' },
    usuarios: { id_user: '' },
    servicios: { id_serv: '', impa_ser: '',sla: 0 },
    cliente: { id_cliente: '' },
    status_Ticket: { id_status_ticket: '' },
    sla_status: '',
    no_serie: '',
    register_date: '',
    last_update_date: ''
  }


  public dataAsignacion = {
    
    
      ticket: {id_ticket: 1},
      id_user_inicio: 1,
      id_user_final: 2,
      comentarios: '',
      register_date:Date.now(),
      last_update_date: Date.now(),
      status_sla: "0"
  
  }

  EstadosRepublicas: any = null;
  EstatusTicket: any = null;
  Servicio: any = null;
  Cliente: any = null;
  ngOnInit(): void {

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






  formSubmit() {



    
    //console.log(this.dataTicket);
    if (this.dataTicket.des_error == '' || this.dataTicket.des_error == null) {
      this.snack.open('La descripcion del Error es Necesario !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }


    if (this.dataTicket.no_serie == '' || this.dataTicket.no_serie == null) {
      this.snack.open('El Numero de Serie es Requerdo!!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }

    
    this.dataTicket.usuarios.id_user = this.loginService.getusarname_storage();
    this.ticketService.agrgarTicket(this.dataTicket).subscribe(
      (data2 : any) => {

       Swal.fire('Ticket Creado', 'Ticket registrado con exito en el sistema', 'success');
       this.router.navigate(['admin/ticket_admin']);
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )
/*

this.dataAsignacion.comentarios= 'Ticket Creado por: ' + this.loginService.getiduser_storage();
this.dataAsignacion.ticket.id_ticket = this.data2.id_ticket;
this.dataAsignacion.id_user_inicio=this.data2.id_ticket;
this.dataAsignacion.id_user_final=this.data2.id_ticket;



this.asignacion.añadirAsignacion(this.dataAsignacion).subscribe(
  (data:any)=>{
    Swal.fire('Ticket Creado asignacion', 'Ticket registrado con exito en el sistema', 'success');
    this.router.navigate(['admin/ticket_admin']);
  },(error) => {
    console.log(error);
    this.snack.open('Ha ocurrido un erroral ingresar al el historial asignacion !!', 'Aceptar', {
      duration: 3000
    });
  }
)*/
/*
        this.dataHistorialTicket.comentario = 'Ticket Creado por: ' + this.loginService.getiduser_storage();
        this.dataHistorialTicket.ticket.id_ticket = (this.data2.id_ticket);
        this.dataHistorialTicket.username = this.loginService.getiduser_storage();
        this.dataHistorialTicket.last_update_date = this.data2.servicios.sla;

        

   

   
console.log(this.dataHistorialTicket);
    this.histTicket.AgregarAlHistorial(this.dataHistorialTicket).subscribe(
      (data5) => {
        Swal.fire('Ticket Creado', 'Ticket registrado con exito en el sistema', 'success');
        

      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un erroral ingresar al el historial  !!', 'Aceptar', {
          duration: 3000
        });
      }
    )



*/
  }

}
