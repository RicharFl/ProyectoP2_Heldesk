import { LoginService } from 'src/app/services/login.service';
import  Swal  from 'sweetalert2';
import { ServiciosService } from './../../../../services/servicios.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-actualiza-servicio',
  templateUrl: './actualiza-servicio.component.html',
  styleUrls: ['./actualiza-servicio.component.css']
})
export class ActualizaServicioComponent implements OnInit {
  servicios :any=null;
   dataServi ={
    "id_serv": '',
    "nom_service": '10'
   }
  constructor(
    private snack: MatSnackBar,
    private route: ActivatedRoute,
    private servicioServ:ServiciosService,
    private router: Router, 
    private loginser:LoginService) { }

  ngOnInit(): void {
    if (this.route.snapshot.params['idservicio'] != undefined) {
      this.dataServi.id_serv = this.route.snapshot.params['idservicio'];
    }
    else {
      this.router.navigate(['admin/servicios']);
    }

    this.servicioServ.ListaServiciosID(this.dataServi).subscribe(
      (data: any) => {
        this.servicios = data;
      },
      (error) => {
        alert("error en la llamada por id");
      }
    )
  }

  onSubmit(): void {
    this.servicios.last_update_date=Date.now();
    this.servicioServ.ActualizaElServicios(this.servicios).subscribe(
      (data) => {
        //console.log(data);
        Swal.fire('Servicio Actulizada', 'Servicio :  '+this.servicios.nom_service+' ha sido egistrado con exito en el sistema', 'success');
        if (this.loginser.getUser()=='1')
        {this.router.navigate(['admin/servicios']);}
        else if (this.loginser.getUser()=='2')
        {this.router.navigate(['gerente_general/servicios']);}
     
        
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )
  }
    salir (){
      if (this.loginser.getUser()=='1')
      {this.router.navigate(['admin/servicios']);}
      else if (this.loginser.getUser()=='2')
      {this.router.navigate(['gerente_general/servicios']);}
    }
}
