import Swal  from 'sweetalert2';
import { Router } from '@angular/router';
import { RolesService } from './../../../../services/roles.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crea-roles',
  templateUrl: './crea-roles.component.html',
  styleUrls: ['./crea-roles.component.css']
})
export class CreaRolesComponent implements OnInit{
  public Roles = {
    nom_per: '',
    desc_per: '',
    niv_perm_per:'',
    register_date: Date.now(),
   last_update_date :Date.now() ,
        
  } 
  constructor(
    private snack: MatSnackBar,
    private RolesServ:RolesService,
    private router: Router) { };
  
    
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  formSubmit() {
    if (this.Roles.nom_per == '' || this.Roles.nom_per == null) {
      this.snack.open('Se requiere Nombre del Rol !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }

    if (this.Roles.desc_per == '' || this.Roles.desc_per == null) {
      this.snack.open('Se requiere la descripcion del Rol !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }

    if (this.Roles.niv_perm_per == '' || this.Roles.niv_perm_per == null) {
      this.snack.open('Se requiere Nivel de Permisos del Rol !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }
    
    this.RolesServ.CreaRol(this.Roles).subscribe(
      (data2 : any) => {
    
       Swal.fire('Rol Creado', ' Rol registrada con exito en el sistema', 'success');
       this.router.navigate(['admin/roles']);
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )


  }


}
