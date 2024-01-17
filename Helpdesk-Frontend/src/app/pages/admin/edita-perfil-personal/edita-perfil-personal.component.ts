import Swal  from 'sweetalert2';
import { UsuariosAdminService } from 'src/app/services/usuarios-admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edita-perfil-personal',
  templateUrl: './edita-perfil-personal.component.html',
  styleUrls: ['./edita-perfil-personal.component.css']
})
export class EditaPerfilPersonalComponent implements OnInit {
  snack: any;
  constructor(private loginService: LoginService, private route: ActivatedRoute,
     private router: Router, private usuariosAdminServi: UsuariosAdminService) { }
  loginData_nuevi = {
    "username": '',
    "password": '10',
  }
 
  username!: string;
  user: any = null;
  ngOnInit(): void {

    //console.log(this.route.snapshot.params['username']);
    if (this.route.snapshot.params['username'] != undefined) {
      this.loginData_nuevi.username = this.route.snapshot.params['username'];
    }
    else {
      this.loginData_nuevi.username = this.loginService.getUsername();
    }
    this.loginService.BuscaUsario(this.loginData_nuevi).subscribe(
      (data: any) => {
        this.user = data;
      },
      (error) => {
        alert("error");
      }
    )



  }

  onSubmit(): void {
    
    this.user.last_update_date = Date.now();
   // console.log(this.user);
    this.usuariosAdminServi.ActulizaDatosDeEmpleado(this.user).subscribe(
      (data) => {
        //console.log(data);
        Swal.fire('Usuario guardado', 'Usuario registrado con exito en el sistema', 'success');
        this.router.navigate(['admin/lista_usuarios']);

        if (this.loginService.getUser()=='1')
  {this.router.navigate(['admin/datos_perfil']);}
  else if (this.loginService.getUser()=='2')
  { //Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');
    this.router.navigate(['gerente_general/datos_perfil']);
  }
  else if (this.loginService.getUser()=='3')
  {this.router.navigate(['cordinador_zona/datos_perfil']);}
  else if (this.loginService.getUser()=='4')
  {this.router.navigate(['agente-mesa/datos_perfil']);}
  else if (this.loginService.getUser()=='5')
  {this.router.navigate(['tecnico_especialista/datos_perfil']);}
  else if (this.loginService.getUser()=='6')
  {this.router.navigate(['almacen/datos_perfil']);}
     
        
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )
  }

salir(){
  if (this.loginService.getUser()=='1')
  {this.router.navigate(['admin/datos_perfil']);}
  else if (this.loginService.getUser()=='2')
  { //Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');
    this.router.navigate(['gerente_general/datos_perfil']);
  }
  else if (this.loginService.getUser()=='3')
  {this.router.navigate(['cordinador_zona/datos_perfil']);}
  else if (this.loginService.getUser()=='4')
  {this.router.navigate(['agente-mesa/datos_perfil']);}
  else if (this.loginService.getUser()=='5')
  {this.router.navigate(['tecnico_especialista/datos_perfil']);}
  else if (this.loginService.getUser()=='6')
  {this.router.navigate(['almacen/datos_perfil']);}
     
}
}
