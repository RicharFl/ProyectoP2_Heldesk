import { LoginService } from './../../../services/login.service';
import  Swal  from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketService } from 'src/app/services/ticket.service';
import { HistorialticketService } from 'src/app/services/historialticket.service';
import { ExportarAExcelService } from 'src/app/services/exportar-aexcel.service';

 
@Component({
  selector: 'app-ticket-admin',
  templateUrl: './ticket-admin.component.html',
  styleUrls: ['./ticket-admin.component.css']
})
export class TicketAdminComponent implements OnInit {
ticket : any []= [];
pagina!:number;
public dataas ={
  username:'',
  username2:''
}

public ticket_AGuardar = {

  id_ticket: '',
  des_error: '',
  register_date: Date.now(),
  last_update_date: Date.now(),
  sla_status: '',
  cliente : {cuenta:{ nombre_cuen: ''}} ,
  estadosrepu: {nombre_esatdo:'' },
  servicios: {nom_service : ''},
    status_Ticket: {nom_status: ''},
    usuarios:{username: ''}
 
}
public ticket_excel = {

  id_ticket: '',
  des_error: '',
  register_date: Date.now(),
  last_update_date: Date.now(),
  sla_status: '',
  cliente : '' ,
  estadosrepu: '',
  servicios: '',
    status_Ticket: '',
    usuarios: ''
 
}
    filterPost = '';
    j : any =[];

constructor(private tickets: TicketService, private router:Router, 
  private histTicketService: HistorialticketService,
   private exportecxel: ExportarAExcelService,
   private loginser:LoginService) { }
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
 if (this.loginser.getUser()=='1' || this.loginser.getUser()=='2')
 {
  this.tickets.listaTodosLosTickets().subscribe(
    (dato:any) => {
      this.ticket = dato;
     this.ticket_AGuardar =dato;
   
    },
    (error) => {
      console.log(error);
      Swal.fire('Error','Error al cargar los Lista de Usuarios completos','error');
    }
  )

 }
 else {
  this.dataas.username= this.loginser.getUsername();
  this.loginser.BuscaUsario(this.dataas).subscribe(
    (dato:any) => {
this.dataas.username2=dato.zonaestados.id_zon;
      this.tickets.ListaTicketsporZona(this.dataas).subscribe(
        (dato:any) => {
          this.ticket = dato;
         this.ticket_AGuardar =dato;
       
        },
        (error) => {
          console.log(error);
          Swal.fire('Error','Error al cargar los usaurios','error');
        }
      )
   
    },
    (error) => {
      console.log(error);
      Swal.fire('Error','Error al cargar los usaurios','error');
    }
  )
 }
 

 

}

DetalleTicket (idticket:string)
{
  if (this.loginser.getUser()=='1')
  {this.router.navigate(['admin/deetalle_ticket',idticket]);}
  else if (this.loginser.getUser()=='2')
  { this.router.navigate(['gerente_general/deetalle_ticket',idticket]);}
  else if (this.loginser.getUser()=='3')
  {this.router.navigate(['cordinador_zona/deetalle_ticket',idticket]);}
  else if (this.loginser.getUser()=='4')
  {this.router.navigate(['agente-mesa/deetalle_ticket',idticket]);}
  else if (this.loginser.getUser()=='5')
  {this.router.navigate(['tecnico_especialista/deetalle_ticket',idticket]);}
  else if (this.loginser.getUser()=='6')
  {this.router.navigate(['almacen/deetalle_ticket',idticket]);}

  //console.log("esto es lo que mando desde admin_ticket");
//console.log("esto es lo que mando desde admin_ticket "+idticket);

  
}



DocTicket (idticket:string)
{
  //console.log("esto es lo que mando desde admin_ticket");
//console.log("esto es lo que mando desde admin_ticket "+idticket);

if (this.loginser.getUser()=='1')
  {this.router.navigate(['admin/documentar_ticket',idticket]);}
  else if (this.loginser.getUser()=='2')
  { //Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');
    this.router.navigate(['gerente_general/documentar_ticket',idticket]);
  }
  else if (this.loginser.getUser()=='3')
  {this.router.navigate(['cordinador_zona/documentar_ticket',idticket]);}
  else if (this.loginser.getUser()=='4')
  {this.router.navigate(['agente-mesa/documentar_ticket',idticket]);}
  else if (this.loginser.getUser()=='5')
  {this.router.navigate(['tecnico_especialista/documentar_ticket',idticket]);}
  else if (this.loginser.getUser()=='6')
  {this.router.navigate(['almacen/documentar_ticket',idticket]);}
}

editarTicket (idticket:string)
{
  //console.log("esto es lo que mando desde admin_ticket");
//console.log("esto es lo que mando desde admin_ticket "+idticket);
if (this.loginser.getUser()=='1')
  {this.router.navigate(['admin/editar_ticket',idticket]);}
  else if (this.loginser.getUser()=='2')
  {this.router.navigate(['gerente_general/editar_ticket',idticket]);}
  else if (this.loginser.getUser()=='3')
  {this.router.navigate(['cordinador_zona/editar_ticket',idticket]);}
  else if (this.loginser.getUser()=='4')
  {this.router.navigate(['agente-mesa/editar_ticket',idticket]);}
  else if (this.loginser.getUser()=='5')
  {Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
  else if (this.loginser.getUser()=='6')
  {Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}

}

asignarTicket (idticket:string)
{
  //console.log("esto es lo que mando desde admin_ticket");
//console.log("esto es lo que mando desde admin_ticket "+idticket);

if (this.loginser.getUser()=='1')
{this.router.navigate(['admin/asignar_ticket',idticket]);}
else if (this.loginser.getUser()=='2')
{this.router.navigate(['gerente_general/asignar_ticket',idticket]);}
else if (this.loginser.getUser()=='3')
{this.router.navigate(['cordinador_zona/asignar_ticket',idticket]);}
else if (this.loginser.getUser()=='4')
{this.router.navigate(['agente-mesa/asignar_ticket',idticket]);}
else if (this.loginser.getUser()=='5')
{Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
else if (this.loginser.getUser()=='6')
{Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}

}
creaticket ()
{
  if (this.loginser.getUser()=='1')
{this.router.navigate(['admin/crear_ticket']);}
else if (this.loginser.getUser()=='2')
{this.router.navigate(['gerente_general/crear_ticket']);}
else if (this.loginser.getUser()=='3')
{this.router.navigate(['cordinador_zona/crear_ticket']);}
else if (this.loginser.getUser()=='4')
{this.router.navigate(['agente-mesa/crear_ticket']);}
else if (this.loginser.getUser()=='5')
{Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
else if (this.loginser.getUser()=='6')
{Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}

}

exportarExcel(): void {
console.log("estoy en la exportacion del Ticket");
/*
this.tickets.listaTodosLosTickets().subscribe(
  (ticket_AGuardara:any) => {
   this.ticket_excel.id_ticket=this.ticket_AGuardar.id_ticket;
      this.ticket_excel.cliente= this.ticket_AGuardar.cliente.cuenta.nombre_cuen;
      this.ticket_excel.sla_status=this.ticket_AGuardar.sla_status;
      this.ticket_excel.register_date=this.ticket_AGuardar.register_date;
      this.ticket_excel.last_update_date=this.ticket_AGuardar.last_update_date;
      this.ticket_excel.estadosrepu =this.ticket_AGuardar.estadosrepu.nombre_esatdo;
      this.ticket_excel.servicios =this.ticket_AGuardar.servicios.nom_service;
      this.ticket_excel.usuarios=this.ticket_AGuardar.usuarios.username;
      this.ticket_excel.des_error= this.ticket_AGuardar.des_error;
      this.ticket_excel.status_Ticket=this.ticket_AGuardar.status_Ticket.nom_status;
    
  },(error) => {
    console.log(error);
    Swal.fire('Error','Error al cargar los usaurios','error');
  }
)*/

this.j =(this.ticket_AGuardar);

    

this.exportecxel.exportHaExcel(this.j, 'Tickets');
  
}

}