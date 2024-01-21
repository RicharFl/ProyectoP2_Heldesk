import  Swal  from 'sweetalert2';
import { LoginService } from 'src/app/services/login.service';
import { ExportarAExcelService } from 'src/app/services/exportar-aexcel.service';
import { Router } from '@angular/router';
import { AlmacenService } from './../../../../services/almacen.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-stok',
  templateUrl: './lista-stok.component.html',
  styleUrls: ['./lista-stok.component.css']
})
export class ListaStokComponent implements OnInit {

  Almacen: any = null;
  pagina!: number;
  filterPost = '';

  almacen_excel:any=null;

  constructor(
    private almacenSER: AlmacenService, 
    private router: Router, 
    private exportecxel: ExportarAExcelService,
    private loginser: LoginService
    ) { }

  ngOnInit(): void {
this.almacenSER.ListaTodoselAlmacen().subscribe(
  (dato: any) => {
    this.Almacen = dato;
  },
  (error) => {
    console.log(error);
    Swal.fire('Error', 'Error al cargar los usaurios', 'error');
  }
)

  }
  

  EditarAlmacen(idstock: string) {
    //console.log("enviare el detalle " + username);
    //this.router.navigate(['admin/clientes/edita/', idcliente]);
    if (this.loginser.getUser()=='1')
     {this.router.navigate(['admin/Almacen-Stock/edita/', idstock]);}
     else if (this.loginser.getUser()=='6')
     {this.router.navigate(['gerente_general/Almacen-Stock/edita/', idstock]);}
     else 
     {Swal.fire('Restricción de Accion', 
     ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
  }

  crearAlmacen(){
   // this.router.navigate(['admin/clientes/edicrear_clienteta/']);
    if (this.loginser.getUser()=='1')
     {this.router.navigate(['admin/Almacen-Stock/crea-Stock']);}
     else if (this.loginser.getUser()=='6')
     {this.router.navigate(['gerente_general/Almacen-Stock/crea-Stock']);}
     else 
     {Swal.fire('Restricción de Accion', 
     ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
  }
  
  
  exportarExcel(): void {
   // this.Clientes.cuenta =this.Clientes.cuenta.nombre_cuen;
    this.almacen_excel =Object.assign(this.Almacen)
    this.exportecxel.exportHaExcel(this.almacen_excel, 'Almacen');
  }

}
