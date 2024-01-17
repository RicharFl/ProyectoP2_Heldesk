import { LoginService } from 'src/app/services/login.service';
import  Swal  from 'sweetalert2';
import { ExportarAExcelService } from 'src/app/services/exportar-aexcel.service';
import { Router } from '@angular/router';
import { ServiciosService } from './../../../../services/servicios.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-servicios',
  templateUrl: './lista-servicios.component.html',
  styleUrls: ['./lista-servicios.component.css']
})
export class ListaServiciosComponent implements OnInit {
  Servicio: any = null;
  pagina!: number;
  filterPost = '';

  constructor(
    private Servicios: ServiciosService, 
    private router: Router, 
    private exportecxel: ExportarAExcelService,
    private loginser:LoginService
    ) { }



  ngOnInit(): void {
    this.Servicios.ListaTodosLosServicios().subscribe(
      (dato: any) => {
        this.Servicio = dato;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error', 'Error al cargar los Roles', 'error');
      }
    )
  }


  EditarServicio(idservicio: string) {
    //console.log("enviare el detalle " + username);
   // this.router.navigate(['admin/servicios/edita/', idservicio]);
    if (this.loginser.getUser()=='1')
    {this.router.navigate(['admin/servicios/edita/', idservicio]);}
    else if (this.loginser.getUser()=='2')
    {this.router.navigate(['gerente_general/servicios/edita/', idservicio]);}
    else 
    {Swal.fire('Restricción de Accion', 
    ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}

  }

crearservicio(){
  //this.router.navigate(['admin/servicios/edita/', idservicio]);
    if (this.loginser.getUser()=='1')
    {this.router.navigate(['admin/servicios/crear_servicio']);}
    else if (this.loginser.getUser()=='2')
    {this.router.navigate(['gerente_general/servicios/crear_servicio']);}
    else 
    {Swal.fire('Restricción de Accion', 
    ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}

}

  
  
  exportarExcel(): void {
    this.exportecxel.exportHaExcel(this.Servicio, 'Servicios');
  }
  

}
