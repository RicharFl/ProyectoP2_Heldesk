import  Swal from 'sweetalert2';
import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-agregar-user-admin',
  templateUrl: './agregar-user-admin.component.html',
  styleUrls: ['./agregar-user-admin.component.css']
})
export class AgregarUserAdminComponent {
  public user = {
    username: '',
    nombre_user: '',
    apellidom_user: '',
    apellidop_user: '',
    correo: '',
    password: '',
    tel_user: '',
    id_perfil: '',
    zonaestados: { id_zon: '' },
    ext_user: '',
    register_date: Date.now(),
    last_update_date: Date.now(),
    staus_user: '',
    perfil: { id_per: '' }


  }



  constructor(private userService: UserService, private snack: MatSnackBar, private router: Router) { };
  ngOnInit(): void { 
   
  }

  formSubmit() {
    console.log(this.user);
    if (this.user.correo == '' || this.user.username == null) {
      this.snack.open('El username de usuario es requerido !!', 'Aceptar', {
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
       // console.log(data);
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
