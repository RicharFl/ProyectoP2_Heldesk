import  Swal  from 'sweetalert2';
import { Router } from '@angular/router';
import { ZonaestadosService } from 'src/app/services/zonaestados.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crea-zona-estados',
  templateUrl: './crea-zona-estados.component.html',
  styleUrls: ['./crea-zona-estados.component.css']
})
export class CreaZonaEstadosComponent implements OnInit {
  
  public ZonaEstado = {
    nombree: '',
    descripcion: '',
    register_date: Date.now(),
   last_update_date :Date.now() ,
        
  }
 

  constructor(
    private snack: MatSnackBar,
    private ZonEstado:ZonaestadosService,
    private router: Router) { };
  
    ngOnInit(): void {}

    formSubmit() {
      if (this.ZonaEstado.nombree == '' || this.ZonaEstado.nombree == null) {
        this.snack.open('Se requiere Nombre de la Zona !!', 'Aceptar', {
          duration: 3000,
          verticalPosition: 'top',
          horizontalPosition: 'right'
        });
        return;
      }
      if (this.ZonaEstado.descripcion == '' || this.ZonaEstado.descripcion == null) {
        this.snack.open('Se requiere la Descripcion !!', 'Aceptar', {
          duration: 3000,
          verticalPosition: 'top',
          horizontalPosition: 'right'
        });
        return;
      }

      this.ZonEstado.CrearZonaEstado(this.ZonaEstado).subscribe(
        (data2 : any) => {
      
         Swal.fire('Zona Creada', 'Zona - Region registrada con exito en el sistema', 'success');
         this.router.navigate(['admin/zona_estados']);
        }, (error) => {
          console.log(error);
          this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
            duration: 3000
          });
        }
      )

    }

}
