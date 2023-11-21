import { Subscriber } from 'rxjs';
import Swal from 'sweetalert2';
import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData = {
    "username": '',
    "password": '',
  }
  validacion_login = 'true';

  constructor(private snack: MatSnackBar, private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {
  }

  formSubmit() {
    if (this.loginData.username.trim() == '' || this.loginData.username.trim() == null) {
      this.snack.open('El nombre de usuario es requerido !!', 'Aceptar', {
        duration: 3000
      })
      return;
    }

    if (this.loginData.password.trim() == '' || this.loginData.password.trim() == null) {
      this.snack.open('La contraseña es requerida !!', 'Aceptar', {
        duration: 3000
      })
      return;
    }

    console.log(this.loginData);


    this.loginService.evaluar_login(this.loginData).subscribe(
      (data: any) => {
      //REVISO QUE TRAE LA EVALUAVION DE LOGIN UN FALSO O UN VERDADERO
        console.log(data);
        if (data == true) {
          console.log("Mandar a inicio")
          console.log(this.loginService.BuscaUsario(this.loginData).subscribe((data: any) => { console.log(data); }));
          this.loginService.BuscaUsario(this.loginData).subscribe(
            (data: any) => 
            { 
              if (data.staus_user == "Pendiente")
              {
                console.log("Empleado no ha sido autorizado cotactar con ADMIN");
                Swal.fire('PENDIENTE', 'Usuario no Autentificado, comunicarce con ADMIN', 'warning');

              }
              else{
                console.log("Mandar a HOME DE USUARIO")
              }
              console.log(data);
             
            })

        }
        else {
          Swal.fire('ERROR', 'Usuario o contraseña incorrecta', 'error');
        }

        //this.loginService.evaluar_login
      }, (error) => {
        console.log(error);

      }



    )



  }








}
