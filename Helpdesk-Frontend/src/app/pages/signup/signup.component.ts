
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {


  public user = {
    username: '',
    nombre_user: '',
    apellidom_user: '',
    apellidop_user: '',
    correo: '',
    password: '',
    tel_user: '',
    id_perfil: '',
    zonaestados : {id_zon : 9},
    ext_user: '',
    register_date: Date.now(),
    last_update_date: Date.now(),
    staus_user: "Pendiente"


  }

  constructor(private userService: UserService, private snack: MatSnackBar) {

  }

  ngOnInit(): void {

  }

  formSubmit() {
    console.log(this.user);
    if (this.user.correo == '' || this.user.correo == null) {
      this.snack.open('El correo de usuario es requerido !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }


    if (this.user.password == '' || this.user.password == null) {
      this.snack.open('El Password del usuario es requerido !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }


    

    this.userService.añadirUsuario(this.user).subscribe(
      (data) => {
        console.log(data);
        Swal.fire('Usuario guardado', 'Usuario registrado con exito en el sistema', 'success');
        
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )




  }



}