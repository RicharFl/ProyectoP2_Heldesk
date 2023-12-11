import { MatSnackBar } from '@angular/material/snack-bar';
import  Swal  from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HistorialticketService } from 'src/app/services/historialticket.service';
import { LoginService } from 'src/app/services/login.service';
import { TicketService } from 'src/app/services/ticket.service';
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

  this.router.navigate(['admin/editar_ticket',idticket]);
}


formSubmit() {

/*
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
*/
}


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
  
}

}
