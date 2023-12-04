import  Swal  from 'sweetalert2';
import { UsuariosAdminService } from './../../../../services/usuarios-admin.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-actualiza-empleado-admin',
  templateUrl: './actualiza-empleado-admin.component.html',
  styleUrls: ['./actualiza-empleado-admin.component.css']
})
export class ActualizaEmpleadoAdminComponent implements OnInit {
  snack: any;
  constructor(private loginService: LoginService, private route: ActivatedRoute, private router: Router, private usuariosAdminServi: UsuariosAdminService) { }
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
    console.log(this.user);
    this.usuariosAdminServi.ActulizaDatosDeEmpleado(this.user).subscribe(
      (data) => {
        //console.log(data);
        Swal.fire('Usuario guardado', 'Usuario registrado con exito en el sistema', 'success');
        this.router.navigate(['admin/lista_usuarios']);
     
        
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )
  }



}
