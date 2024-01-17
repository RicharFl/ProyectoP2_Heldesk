import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-datos-perfil',
  templateUrl: './datos-perfil.component.html',
  styleUrls: ['./datos-perfil.component.css']
})





export class DatosPerfilComponent implements OnInit {
  user: any = [];


  constructor(private loginService: LoginService, private route: ActivatedRoute, private router: Router) { }
  loginData_nuevi = {
    "username": '',
    "password": '10',
  }
  username!: string; 
  ngOnInit(): void {

    console.log(this.route.snapshot.params['username'] );
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

  EditarDelEmpleado(username:string){
  //  console.log("enviare el detalle "+ username);
   // this.router.navigate(['admin/Actualizainfopersonal',username]);
    if (this.loginService.getUser()=='1')
    {this.router.navigate(['admin/Actualizainfopersonal',username]);}
    else if (this.loginService.getUser()=='2')
    { //Swal.fire('Restricción de Accion', ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');
      this.router.navigate(['gerente_general/Actualizainfopersonal',username]);
    }
    else if (this.loginService.getUser()=='3')
    {this.router.navigate(['cordinador_zona/Actualizainfopersonal',username]);}
    else if (this.loginService.getUser()=='4')
    {this.router.navigate(['agente-mesa/Actualizainfopersonal',username]);}
    else if (this.loginService.getUser()=='5')
    {this.router.navigate(['tecnico_especialista/Actualizainfopersonal',username]);}
    else if (this.loginService.getUser()=='6')
    {this.router.navigate(['almacen/Actualizainfopersonal',username]);}
  }



}
