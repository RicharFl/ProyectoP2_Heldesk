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
    private clientes: ClienteService, private loginService: LoginService, private histTicket: HistorialticketService) { };
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

    ticket: { id_ticket: '' },
    username: '',
    comentario: '',
    fec_inicio: Date.now(),
    sla_status_hist: 0,
    register_date: Date.now(),
    last_update_date: Date.now(),
    sla_ticket: { id_sla: 1 }
  }


  public data2 = {
    id_ticket: '',
    des_error: '',
    estadosrepu: { id_est_repu: '' },
    usuarios: { id_user: '' },
    servicios: { id_serv: '', impa_ser: '' },
    cliente: { id_cliente: '' },
    status_Ticket: { id_status_ticket: '' },
    sla_status: '',
    no_serie: '',
    register_date: '',
    last_update_date: ''
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
    // console.log(this.user);
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
      (data1) => {

        localStorage.setItem('idTicketLocalestorage', JSON.stringify(data1));

        this.ticketService.BuscaPorId_Ticket(data1).subscribe(
          (data2: any) => {
            //console.log("estoy buscando informcion del ticket agregado");
            //localStorage.setItem('username_front',JSON.stringify(data.username));
            //console.log(data2);
            //console.log("Este es el ID del ticket "+(data2.id_ticket));
            //  console.log(this.data2);
            this.dataHistorialTicket.comentario = 'Ticket Creado por: ' + this.loginService.getiduser_storage();
            this.dataHistorialTicket.ticket.id_ticket = data2.id_ticket;
            this.dataHistorialTicket.username = this.loginService.getiduser_storage();

            if (this.data2.servicios.impa_ser == 'Alto') {
              this.dataHistorialTicket.sla_status_hist = 18;
              this.dataHistorialTicket.sla_ticket.id_sla = 1;

            }
            else if (this.data2.servicios.impa_ser == 'Medio') {
              this.dataHistorialTicket.sla_status_hist = 52;
              this.dataHistorialTicket.sla_ticket.id_sla = 2;
            }
            else {
              this.dataHistorialTicket.sla_status_hist = 168;
              this.dataHistorialTicket.sla_ticket.id_sla = 3;
            }

          }
        )

        ///   console.log("este es el JSON PARA HISTORIAL");
        ///  console.log (this.dataHistorialTicket);


        //console.log(data1);


      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )

    this.histTicket.AgregarAlHistorial(this.dataHistorialTicket).subscribe(
      (data5) => {
        Swal.fire('Ticket Creado', 'Ticket registrado con exito en el sistema', 'success');
        this.router.navigate(['admin/ticket_admin']);

      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un erroral ingresar al el historial  !!', 'Aceptar', {
          duration: 3000
        });
      }
    )





  }

}
