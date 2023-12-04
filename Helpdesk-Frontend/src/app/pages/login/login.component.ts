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
         // console.log("Mandar a inicio")
          //console.log(this.loginService.BuscaUsario(this.loginData).subscribe((data: any) => { console.log(data); }));
          this.loginService.BuscaUsario(this.loginData).subscribe(
            (data: any) => 
            { 
              console.log ("este es el perfil de usurio "+ data.perfil.id_per);
              if (data.staus_user == "Pendiente")
              {
                //console.log("Empleado no ha sido autorizado cotactar con ADMIN");
                Swal.fire('PENDIENTE', 'Usuario en espera de aprobacion, comunicarce con ADMIN', 'warning');

              }
              else{
                this.loginService.SAVE_LOCAL_STORAGE_USER(this.loginData) 
              //  console.log(this.loginService.getUser());
               // console.log("pase save_local_storage");
                
                if(this.loginService.getUserRole()==1){
                 // console.log("Mandar a HOME DE USUARIO");
                  this.router.navigate(['admin'])
                 this.loginService.loginStatusSubjec.next(true);
                }
                else if (this.loginService.getUserRole()==2)
                {
                  this.router.navigate(['gerente_general'])
                  this.loginService.loginStatusSubjec.next(true);
                }
                else if (this.loginService.getUserRole()==3)
                {
                  this.router.navigate(['cordinador_zona'])
                  this.loginService.loginStatusSubjec.next(true);
                }
                else if (this.loginService.getUserRole()==4)
                {
                  this.router.navigate(['agente-mesa'])
                  this.loginService.loginStatusSubjec.next(true);
                } 
                else if (this.loginService.getUserRole()==5)
                {
                  this.router.navigate(['tecnico_especialista'])
                  this.loginService.loginStatusSubjec.next(true);
                }
                else if (this.loginService.getUserRole()==6)
                {
                  this.router.navigate(['almacen'])
                  this.loginService.loginStatusSubjec.next(true);
                }
                else {
                  this.router.navigate(['login'])
                  this.loginService.loginStatusSubjec.next(true);

                }
              
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
