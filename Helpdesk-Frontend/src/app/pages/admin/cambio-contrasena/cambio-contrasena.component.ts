import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';
import { UsuariosAdminService } from 'src/app/services/usuarios-admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cambio-contrasena',
  templateUrl: './cambio-contrasena.component.html',
  styleUrls: ['./cambio-contrasena.component.css']
})
export class CambioContrasenaComponent implements OnInit {
  loginData_nuevi = {
    "username": '',
    "password": '10',
  }
password ={
  "password": '',
  "passwordConfirmacion": '',
}
user: any = [];
constructor(private snack: MatSnackBar, private router: Router,
   private userService : UsuariosAdminService,private loginService: LoginService) { }

ngOnInit(): void {
  this.loginData_nuevi.username = this.loginService.getUsername();
  this.loginService.BuscaUsario(this.loginData_nuevi).subscribe(
    (data: any) => {
      this.user = data;
    },
    (error) => {
      alert("error");
    }
  )
}


  formSubmit() {
    if (this.password.password.trim() == '' || this.password.password.trim() == null) {
      this.snack.open('La constraseña Inicial es Requerida !!', 'Aceptar', {
        duration: 3000
      })
      return;
    }

    if (this.password.passwordConfirmacion.trim() == '' || this.password.passwordConfirmacion.trim() == null) {
      this.snack.open('La confirmacion de constraseña es Requerida  !!', 'Aceptar', {
        duration: 3000
      })
      return;
    }

    if (this.password.password.trim() != this.password.passwordConfirmacion.trim()) {
      this.snack.open('Revisar Contraseñas - Son Diferentes !!', 'Aceptar', {
        duration: 3000
      })
      return;
    }
    this.user.password= this.password.password;
this.userService.ActulizaContrasena(this.user).subscribe(
  (data) => {
    //console.log(data);
    Swal.fire('Contraseña Actulizada', 'Actulizacion de Contraseña Correctamente', 'success');
    this.router.navigate(['admin/estadisticas']);
    if (this.loginService.getUser()=='1')
  {this.router.navigate(['admin/estadisticas']);}
  else if (this.loginService.getUser()=='2')
  { //Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');
    this.router.navigate(['gerente_general/estadisticas']);
  }
  else if (this.loginService.getUser()=='3')
  {this.router.navigate(['cordinador_zona/estadisticas']);}
  else if (this.loginService.getUser()=='4')
  {this.router.navigate(['agente-mesa/estadisticas']);}
  else if (this.loginService.getUser()=='5')
  {this.router.navigate(['tecnico_especialista/estadisticas']);}
  else if (this.loginService.getUser()=='6')
  {this.router.navigate(['almacen/estadisticas']);}
    
  }, (error) => {
    console.log(error);
    this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
      duration: 3000
    });
  }
)




  }
}
