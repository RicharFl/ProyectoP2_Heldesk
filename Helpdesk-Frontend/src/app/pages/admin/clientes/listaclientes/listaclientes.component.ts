import { LoginService } from 'src/app/services/login.service';
import  Swal  from 'sweetalert2';
import { ExportarAExcelService } from 'src/app/services/exportar-aexcel.service';
import { ClienteService } from './../../../../services/cliente.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listaclientes',
  templateUrl: './listaclientes.component.html',
  styleUrls: ['./listaclientes.component.css']
})
export class ListaclientesComponent implements OnInit {

  Clientes: any = null;
  pagina!: number;
  filterPost = '';

  cliente_excel:any=null;

  constructor(
    private clienteServ: ClienteService, 
    private router: Router, 
    private exportecxel: ExportarAExcelService,
    private loginser: LoginService
    ) { }

  ngOnInit(): void {
this.clienteServ.ListaTodosLosClientes().subscribe(
  (dato: any) => {
    this.Clientes = dato;
  },
  (error) => {
    console.log(error);
    Swal.fire('Error', 'Error al cargar los usaurios', 'error');
  }
)

  }
  

  EditarCliente(idcliente: string) {
    //console.log("enviare el detalle " + username);
    //this.router.navigate(['admin/clientes/edita/', idcliente]);
    if (this.loginser.getUser()=='1')
     {this.router.navigate(['admin/clientes/edita/', idcliente]);}
     else if (this.loginser.getUser()=='2')
     {this.router.navigate(['gerente_general/clientes/edita/', idcliente]);}
     else 
     {Swal.fire('Restricción de Accion', 
     ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
  }

  crearclientes(){
   // this.router.navigate(['admin/clientes/edicrear_clienteta/']);
    if (this.loginser.getUser()=='1')
     {this.router.navigate(['admin/clientes/crear_cliente/']);}
     else if (this.loginser.getUser()=='2')
     {this.router.navigate(['gerente_general/clientes/crear_cliente/']);}
     else 
     {Swal.fire('Restricción de Accion', 
     ' No tiene los permisos Necesarios, solicita actulizacion de permisos al Administrador', 'warning');}
  }
  
  
  exportarExcel(): void {
   // this.Clientes.cuenta =this.Clientes.cuenta.nombre_cuen;
    this.cliente_excel =Object.assign(this.Clientes,this.Clientes.cuenta);
    this.exportecxel.exportHaExcel(this.cliente_excel, 'Clientes');
  }
  




  


}
