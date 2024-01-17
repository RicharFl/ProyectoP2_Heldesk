import { LoginService } from 'src/app/services/login.service';
import  Swal  from 'sweetalert2';
import { Router } from '@angular/router';
import { CuentaDependenciaService } from './../../../../services/cuenta-dependencia.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crea-cuenta-dependencia',
  templateUrl: './crea-cuenta-dependencia.component.html',
  styleUrls: ['./crea-cuenta-dependencia.component.css']
})
export class CreaCuentaDependenciaComponent implements OnInit {

  public Cuenta = {
    nombre_cuen: '',
    alcan_cuen: '',
    desc_cuenta:'',
    repre_cuen:'',
    register_date: Date.now(),
   last_update_date :Date.now() ,
        
  } 
  constructor(
    private snack: MatSnackBar,
    private cuentaSer:CuentaDependenciaService,
    private router: Router,
    private loginser: LoginService) { }
    
    ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
; 
formSubmit() {
  if (this.Cuenta.nombre_cuen == '' || this.Cuenta.nombre_cuen == null) {
    this.snack.open('Se requiere Nombre de la Cuenta !!', 'Aceptar', {
      duration: 3000,
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
    return;
  }

  if (this.Cuenta.alcan_cuen == '' || this.Cuenta.alcan_cuen == null) {
    this.snack.open('Se requiere Alcance de la Cuenta !!', 'Aceptar', {
      duration: 3000,
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
    return;
  }

  
  if (this.Cuenta.desc_cuenta == '' || this.Cuenta.desc_cuenta == null) {
    this.snack.open('Se requiere la Descripcion de la Cuenta !!', 'Aceptar', {
      duration: 3000,
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
    return;
  }

    
  if (this.Cuenta.repre_cuen == '' || this.Cuenta.repre_cuen == null) {
    this.snack.open('Se requiere el Nombre del Representante de Cuenta !!', 'Aceptar', {
      duration: 3000,
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
    return;
  }


  this.cuentaSer.CreaCuentasDependencias(this.Cuenta).subscribe(
    (data2 : any) => {
  
     Swal.fire('Cuenta Creada', ' Cuenta registrada con exito en el sistema', 'success');
     //this.router.navigate(['admin/cuentas_dependencia']);
     if (this.loginser.getUser()=='1')
     {this.router.navigate(['admin/cuentas_dependencia']);}
     else if (this.loginser.getUser()=='2')
     {this.router.navigate(['gerente_general/cuentas_dependencia']);}
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
