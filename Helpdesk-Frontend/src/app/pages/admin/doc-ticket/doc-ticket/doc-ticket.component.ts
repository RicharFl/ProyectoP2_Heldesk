import { TicketService } from './../../../../services/ticket.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import  Swal  from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HistorialticketService } from 'src/app/services/historialticket.service';
import { LoginService } from 'src/app/services/login.service';

import { FormBuilder, FormGroup } from '@angular/forms';



@Component({
  selector: 'app-doc-ticket',
  templateUrl: './doc-ticket.component.html',
  styleUrls: ['./doc-ticket.component.css']
})
export class DocTicketComponent implements OnInit{
  ticket: any = null;
  histrial_tiket:any=null;
  pagina!:number;
  ticket_data={
"id_ticket":'',
"des_error": ''
  }
  user:any=null;
  //let i: number = 2;
  resultad_fechas :number =0;

  public dataTicket = {
    id_ticket:'',
    des_error: '',
    estadosrepu: { id_est_repu: '' },
    usuarios: { id_user: '' },
    servicios: { id_serv: '', sla: 0 },
    cliente: { id_cliente: '' },
    status_Ticket: { id_status_ticket: '' },
    sla_status: 'En tiempo',
    no_serie: '',
    register_date: Date.now(),
    last_update_date: Date.now()
  }
  
  fechainicio: any=null;
  fechafin: any=null;

  public dataHistorialTicket = {

    ticket: { id_ticket: '' },
    username: '',
    comentario: '',
    fec_inicio: Date.now(),
    sla_status_hist: 0,
    register_date: Date.now(),
    last_update_date: Date.now()
   
  }
  form : FormGroup;
  nextClicked = false;
  constructor(private tickets: TicketService, private route: ActivatedRoute, private router: Router,private historialTikcet:HistorialticketService,
    private login:LoginService, private snack: MatSnackBar ) { }
  
  
  ngOnInit(): void {

    //console.log(this.route.snapshot.params['idticket'] );

    if (this.route.snapshot.params['idticket'] != undefined) {
      this.ticket_data.id_ticket = this.route.snapshot.params['idticket'];     
      this.dataHistorialTicket.ticket.id_ticket = this.route.snapshot.params['idticket']
    }
    else {
      this.router.navigate(['admin/ticket_admin']);
    }
    this.tickets.BuscaPorId_Ticket(this.ticket_data).subscribe(
      (data: any) => {
        this.ticket = data;
        this.dataTicket=data;
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

   // console.log("Usuario con datos de Ticket");
 
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


formSubmit() {


  if (this.dataHistorialTicket.comentario == '' || this.dataHistorialTicket.comentario == null) {
    this.snack.open('El comentario es Necesario !!', 'Aceptar', {
      duration: 3000,
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
    return;
  }




  this.fechainicio = new Date (this.dataTicket.register_date);
  this.fechafin=Date.now();
  
  console.log("la diferencia entre fechas es de :" );
  console.log((this.fechafin- this.fechainicio)/3600000);

  this.resultad_fechas = this.dataTicket.servicios.sla - ((this.fechafin- this.fechainicio)/3600000);
  this.resultad_fechas=Number(this.resultad_fechas.toFixed(2));
  console.log(this.resultad_fechas);

  this.dataHistorialTicket.ticket.id_ticket = this.route.snapshot.params['idticket']
  this.dataHistorialTicket.username=this.login.getUsername();
  this.dataHistorialTicket.sla_status_hist =this.resultad_fechas;
  if (this.resultad_fechas < 0){
    this.dataHistorialTicket.sla_status_hist = 0 ;
    this.dataTicket.sla_status ="Fuera de tiempo";
this.tickets.actualizaTicket(this.dataTicket).subscribe(
  (data2:any) => {alert("Ticket Fuera de Tiempo");} ,(error) => {
    alert("Errror al actulkizar el ticket");
  }

)
    
  }


  this.historialTikcet.AgregarAlHistorial(this.dataHistorialTicket).subscribe(
    (data_histtiket: any) => {
      Swal.fire('Ticket Documentado Correctamente', 'El ticket Fue documentado', 'success');
        
      if (this.login.getUser()=='1')
      {this.router.navigate(['admin/ticket_admin']);}
      else if (this.login.getUser()=='2')
      { //Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');
        this.router.navigate(['gerente_general/ticket_admin']);
      }
      else if (this.login.getUser()=='3')
      {this.router.navigate(['cordinador_zona/ticket_admin']);}
      else if (this.login.getUser()=='4')
      {this.router.navigate(['agente-mesa/ticket_admin']);}
      else if (this.login.getUser()=='5')
      {this.router.navigate(['tecnico_especialista/ticket_admin']);}
      else if (this.login.getUser()=='6')
      {this.router.navigate(['almacen/ticket_admin']);}
    },
      (error) => {
        alert("Errror al Insertar en el Historial");
      }
  )



}


salir()
{
  if (this.login.getUser()=='1')
  {this.router.navigate(['admin/ticket_admin']);}
  else if (this.login.getUser()=='2')
  { //Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');
    this.router.navigate(['gerente_general/ticket_admin']);
  }
  else if (this.login.getUser()=='3')
  {this.router.navigate(['cordinador_zona/ticket_admin']);}
  else if (this.login.getUser()=='4')
  {this.router.navigate(['agente-mesa/ticket_admin']);}
  else if (this.login.getUser()=='5')
  {this.router.navigate(['tecnico_especialista/ticket_admin']);}
  else if (this.login.getUser()=='6')
  {this.router.navigate(['almacen/ticket_admin']);}

}



/*
public CerrarTicket(){
  if (this.dataHistorialTicket.comentario == '' || this.dataHistorialTicket.comentario == null) {
    this.snack.open('El comentario es Necesario !!', 'Aceptar', {
      duration: 3000,
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
    return;
  }


  console.log("estoy en cerrar ticket");
}
public DocumentarTick()
{

  if (this.dataHistorialTicket.comentario == '' || this.dataHistorialTicket.comentario == null) {
    this.snack.open('El comentario es Necesario !!', 'Aceptar', {
      duration: 3000,
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
    return;
  }





  this.dataHistorialTicket.ticket.id_ticket = this.route.snapshot.params['idticket']
  this.dataHistorialTicket.username=this.login.getUsername();

  this.historialTikcet.AgregarAlHistorial(this.dataHistorialTicket).subscribe(
    (data_histtiket: any) => {
      Swal.fire('Ticket Documentado Correctamente', 'El ticket Fue documentado', 'success');
        
      this.router.navigate(['admin/ticket_admin']);
    },
      (error) => {
        alert("Errror al Insertar en el Historial");
      }
  )
  
}*/

}
