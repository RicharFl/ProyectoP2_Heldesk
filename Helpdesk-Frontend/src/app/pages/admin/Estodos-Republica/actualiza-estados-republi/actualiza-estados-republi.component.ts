import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EstadosrepublicaService } from 'src/app/services/estadosrepublica.service';
import { ZonaestadosService } from 'src/app/services/zonaestados.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-actualiza-estados-republi',
  templateUrl: './actualiza-estados-republi.component.html',
  styleUrls: ['./actualiza-estados-republi.component.css']
})
export class ActualizaEstadosRepubliComponent implements OnInit{

  EstadoRepu: any = null;
  ZonaEstado: any=null;
  snack: any;
  dataEstado={
    "id_est_repu": '',
    "nombre_esatdo": '10',
  }
  constructor(
    private estadoRepublica: EstadosrepublicaService, 
    private router: Router,
    private route: ActivatedRoute,
    private ZonEstado: ZonaestadosService
    ) { }

    ngOnInit(): void {
      if (this.route.snapshot.params['idEdo'] != undefined) {
        this.dataEstado.id_est_repu = this.route.snapshot.params['idEdo'];
      }
      else {
        this.router.navigate(['admin/estados_republica']);
      }

      this.estadoRepublica.BuscaEstadosDelaRepublicaPorID(this.dataEstado).subscribe(
        (data: any) => {
          this.EstadoRepu = data;
        },
        (error) => {
          alert("error");
        }
      )

      this.ZonEstado.ListaTodosLasZonas().subscribe(
        (data: any) => {
          this.ZonaEstado = data;
        },
        (error) => {
          alert("error");
        }
      )


    }
    onSubmit(): void {

this.EstadoRepu.last_update_date=Date.now();
this.estadoRepublica.ActulizaEstadoRepublica(this.EstadoRepu).subscribe(
  (data) => {
    //console.log(data);
    Swal.fire('Estado Actulizado', 'Estado '+this.EstadoRepu.nombre_esatdo+' ha sido egistrado con exito en el sistema', 'success');
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
