import  Swal  from 'sweetalert2';
import { Router, ActivatedRoute } from '@angular/router';
import { ZonaestadosService } from 'src/app/services/zonaestados.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-actuliza-zona-estados',
  templateUrl: './actuliza-zona-estados.component.html',
  styleUrls: ['./actuliza-zona-estados.component.css']
})
export class ActulizaZonaEstadosComponent implements OnInit{

  ZonaEstado: any=null;
  snack: any;
  dataZona={
    "id_zon": '',
    "nombree": '10',
  }
  constructor(
  
    private router: Router,
    private route: ActivatedRoute,
    private ZonEstado: ZonaestadosService
    ) { }

    ngOnInit(): void {
      if (this.route.snapshot.params['idZonEdo'] != undefined) {
        this.dataZona.id_zon = this.route.snapshot.params['idZonEdo'];
      }
      else {
        this.router.navigate(['admin/zona_estados']);
      }

      this.ZonEstado.ListaZonaEstadoPorId(this.dataZona).subscribe(
        (data: any) => {
          this.ZonaEstado = data;
        },
        (error) => {
          alert("error");
        }
      )


    }

    onSubmit(): void {
      this.ZonaEstado.last_update_date=Date.now();

      this.ZonEstado.ActulizaZonaEstados(this.ZonaEstado).subscribe(
        (data) => {
          //console.log(data);
          Swal.fire('Zona Actulizada', 'Zona :  '+this.ZonaEstado.nombree+' ha sido egistrado con exito en el sistema', 'success');
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
