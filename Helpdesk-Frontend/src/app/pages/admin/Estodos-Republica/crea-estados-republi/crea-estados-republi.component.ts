import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { EstadosrepublicaService } from 'src/app/services/estadosrepublica.service';
import { ZonaestadosService } from 'src/app/services/zonaestados.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crea-estados-republi',
  templateUrl: './crea-estados-republi.component.html',
  styleUrls: ['./crea-estados-republi.component.css']
})
export class CreaEstadosRepubliComponent implements OnInit {
  
  public EstadosRepublicas = {
    nombre_esatdo: '',
    descripcion: '',
    register_date: Date.now(),
   last_update_date :Date.now() ,
             
    zona: {id_zon:''}
  }
  ZonaEstado: any=null;

  constructor(private EstadoRepub : EstadosrepublicaService,
    private snack: MatSnackBar,
    private ZonEstado:ZonaestadosService,
    private router: Router) { };
  
  
    ngOnInit(): void {

    this.ZonEstado.ListaTodosLasZonas().subscribe(
      (data: any) => {
        this.ZonaEstado = data;
      },
      (error) => {
        alert("error");
      }
    )

  }


  formSubmit() {
    if (this.EstadosRepublicas.nombre_esatdo == '' || this.EstadosRepublicas.nombre_esatdo == null) {
      this.snack.open('Se requiere Nombre de Estado !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }

    if (this.EstadosRepublicas.descripcion == '' || this.EstadosRepublicas.descripcion == null) {
      this.snack.open('Se requiere Nombre de Descripcion !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }
    this.EstadosRepublicas.register_date =Date.now();
    this.EstadosRepublicas.last_update_date =Date.now();

this.EstadoRepub.CrearEstadoDeLaRepublica(this.EstadosRepublicas).subscribe(
  (data2 : any) => {

   Swal.fire('Estado Creado', 'Entidad Federativa registrada con exito en el sistema', 'success');
   this.router.navigate(['admin/estados_republica']);
  }, (error) => {
    console.log(error);
    this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
      duration: 3000
    });
  }
)




  }

  
}
