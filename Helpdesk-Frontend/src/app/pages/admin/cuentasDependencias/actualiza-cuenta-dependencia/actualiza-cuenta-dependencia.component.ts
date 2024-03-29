import { LoginService } from 'src/app/services/login.service';
import  Swal  from 'sweetalert2';
import { CuentaDependenciaService } from './../../../../services/cuenta-dependencia.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-actualiza-cuenta-dependencia',
  templateUrl: './actualiza-cuenta-dependencia.component.html',
  styleUrls: ['./actualiza-cuenta-dependencia.component.css']
})
export class ActualizaCuentaDependenciaComponent implements OnInit {
  Cuenta :any=null;
   dataCuenta ={
    "id_cuen": '',
    "nombre_cuen": '10'
   }
  constructor(
    private snack: MatSnackBar,
    private route: ActivatedRoute,
    private cuentaSer:CuentaDependenciaService,
    private router: Router,private  loginser:LoginService ) { }


    ngOnInit(): void {
      if (this.route.snapshot.params['idcuenta'] != undefined) {
        this.dataCuenta.id_cuen = this.route.snapshot.params['idcuenta'];
      }
      else {
        if (this.loginser.getUser()=='1')
     {this.router.navigate(['admin/cuentas_dependencia']);}
     else if (this.loginser.getUser()=='2')
     {this.router.navigate(['gerente_general/cuentas_dependencia']);}
     else 
     {Swal.fire('Restricción de Accion', 
     ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
      }

      this.cuentaSer.ListaCuentasDependenciasId(this.dataCuenta).subscribe(
        (data: any) => {
          this.Cuenta = data;
        },
        (error) => {
          alert("error en la llamada por id");
        }
      )

    }
    onSubmit(): void {

      this.Cuenta.last_update_date=Date.now();
     this.cuentaSer.ActualizaCuentasDependencias(this.Cuenta).subscribe(
        (data) => {
          //console.log(data);
          Swal.fire('Cuenta Actulizada', 'Cuenta :  '+this.Cuenta.nombre_cuen +' ha sido egistrado con exito en el sistema', 'success');
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
    salir(){
      if (this.loginser.getUser()=='1')
     {this.router.navigate(['admin/cuentas_dependencia']);}
     else if (this.loginser.getUser()=='2')
     {this.router.navigate(['gerente_general/cuentas_dependencia']);}
     else 
     {Swal.fire('Restricción de Accion', 
     ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
     
    }
}
