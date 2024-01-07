import  Swal  from 'sweetalert2';
import { RolesService } from './../../../../services/roles.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-actiliza-roles',
  templateUrl: './actiliza-roles.component.html',
  styleUrls: ['./actiliza-roles.component.css']
})
export class ActilizaRolesComponent implements OnInit{

   Roles :any=null;
   dataRol ={
    "id_per": '',
    "nom_per": '10'
   }
  constructor(
    private snack: MatSnackBar,
    private route: ActivatedRoute,
    private RolesServ:RolesService,
    private router: Router) { }
    
    
    ngOnInit(): void {
      if (this.route.snapshot.params['idRol'] != undefined) {
        this.dataRol.id_per = this.route.snapshot.params['idRol'];
      }
      else {
        this.router.navigate(['admin/roles']);
      }

      this.RolesServ.ListaRolporID(this.dataRol).subscribe(
        (data: any) => {
          this.Roles = data;
        },
        (error) => {
          alert("error en la llamada por id");
        }
      )
 
  }
  onSubmit(): void {
    this.Roles.last_update_date=Date.now();
    this.RolesServ.ActualizaElRol(this.Roles).subscribe(
      (data) => {
        //console.log(data);
        Swal.fire('Rol Actulizada', 'Rol :  '+this.Roles.nom_per+' ha sido egistrado con exito en el sistema', 'success');
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
