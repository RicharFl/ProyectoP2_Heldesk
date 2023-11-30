import { ExportarAExcelService } from './../../../../services/exportar-aexcel.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { UsuariosAdminService } from './../../../../services/usuarios-admin.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-lista-empleados-admin',
  templateUrl: './lista-empleados-admin.component.html',
  styleUrls: ['./lista-empleados-admin.component.css']
})
export class ListaEmpleadosAdminComponent implements OnInit {

  usuarios: any = [

  ]


  pagina!: number;
  constructor(private listUsaurios: UsuariosAdminService, private router: Router, private exportecxel: ExportarAExcelService) { }
  dataSource: any = [

  ]
  ngOnInit(): void {
    this.listUsaurios.listaTodosLosEmpleados().subscribe(
      (dato: any) => {
        this.usuarios = dato;
       // this.dataSource=dato;
        //delete this.dataSource.password;
      
        //console.log(this.usuarios);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error', 'Error al cargar los usaurios', 'error');
      }
    )





  }
  filterPost = '';
  filterPost2 = '';

  verDetallesDelEmpleado(username: string) {
    console.log("enviare el detalle " + username);
    this.router.navigate(['admin/datos_perfil', username]);
  }

  EditarDelEmpleado(username: string) {
    console.log("enviare el detalle " + username);
    this.router.navigate(['admin/actualiza_usuario', username]);
  }



  

exportarExcel(): void {
 
  this.dataSource =this.usuarios;
  console.log(this.usuarios);

  this.exportecxel.exportHaExcel(this.dataSource, 'empledos');
}

}

