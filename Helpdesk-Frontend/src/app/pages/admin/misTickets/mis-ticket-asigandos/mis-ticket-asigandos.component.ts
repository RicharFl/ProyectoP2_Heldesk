import  Swal  from 'sweetalert2';
import { ExportarAExcelService } from 'src/app/services/exportar-aexcel.service';
import { HistorialticketService } from 'src/app/services/historialticket.service';
import { TicketService } from 'src/app/services/ticket.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';


@Component({
  selector: 'app-mis-ticket-asigandos',
  templateUrl: './mis-ticket-asigandos.component.html',
  styleUrls: ['./mis-ticket-asigandos.component.css']
})
export class MisTicketAsigandosComponent implements OnInit{
  ticket : any []= [];
  pagina!:number;
  
  public ticket_mios = {
    id_ticket: '1',
    id_user: ''
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
  
  constructor(private tickets: TicketService, 
    private router:Router, 
    private histTicketService: HistorialticketService, 
    private exportecxel: ExportarAExcelService,
    private loginser:LoginService ) { }

  ngOnInit(): void {
this.ticket_mios.id_user = localStorage.getItem('id_user_front');
    this.tickets.ListaMisTicketAsigandos(this.ticket_mios).subscribe(
      (dato:any) => {
        this.ticket = dato;
       this.ticket_AGuardar =dato;
     
      },
      (error) => {
        console.log(error);
        Swal.fire('Error','Error al cargar los usaurios','error');
      }
    )
  
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
  crearticket ()
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
//  console.log("estoy en la exportacion del Ticket");

  
  this.j =(this.ticket_AGuardar);
  
      
  
  this.exportecxel.exportHaExcel(this.j, 'Tickets');
    
  }
}
