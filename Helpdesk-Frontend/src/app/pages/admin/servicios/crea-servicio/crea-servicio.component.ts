import { LoginService } from 'src/app/services/login.service';
import  Swal  from 'sweetalert2';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ServiciosService } from './../../../../services/servicios.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crea-servicio',
  templateUrl: './crea-servicio.component.html',
  styleUrls: ['./crea-servicio.component.css']
})
export class CreaServicioComponent implements OnInit {
  
  public Servicios = {
    nom_service: '',
    descr_ser: '',
    impa_ser: '',
    sla: '',
    
    register_date: Date.now(),
   last_update_date :Date.now() ,  

  }
  cuentadata: any=null;

  constructor(
    private snack: MatSnackBar,
    private ServicioServ:ServiciosService,
    private router: Router,
    private loginser:LoginService
    ) { }


  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


  formSubmit() {

    if (this.Servicios.nom_service == '' || this.Servicios.nom_service == null) {
      this.snack.open('Se requiere Nombre del Servcio !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }
    
    if (this.Servicios.sla == '' || this.Servicios.sla == null) {
      this.snack.open('Se requiere Nivel de SLA del Servcio !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }

    this.ServicioServ.creaServicios(this.Servicios).subscribe(
      (data:any) =>{
        Swal.fire('Servicio Creado', 'Servicio registrado con exito en el sistema', 'success');
       // this.router.navigate(['admin/servicios']);
        if (this.loginser.getUser()=='1')
        {this.router.navigate(['admin/servicios']);}
        else if (this.loginser.getUser()=='2')
        {this.router.navigate(['gerente_general/servicios']);}
        else 
        {Swal.fire('Restricción de Accion', 
        ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )
  }
}
