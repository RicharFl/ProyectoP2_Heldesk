import { ExportarAExcelService } from './../../../../services/exportar-aexcel.service';
import { Router } from '@angular/router';
import  Swal  from 'sweetalert2';
import { UsuariosAdminService } from './../../../../services/usuarios-admin.service';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { filter } from 'rxjs';

@Component({
  selector: 'app-lista-empleados-admin',
  templateUrl: './lista-empleados-admin.component.html',
  styleUrls: ['./lista-empleados-admin.component.css']
})
export class ListaEmpleadosAdminComponent implements OnInit{

  usuarios : any = [

  ]
  columnas: string[] = ['nombre_user', 'apellidom_use', 'apellidop_user','staus_user', 'nom_per','nombree'];
  
  pagina!:number;
  constructor(private listUsaurios:UsuariosAdminService, private router:Router, private exportecxel:ExportarAExcelService) { }
  dataSource:any; 
  
  ngOnInit(): void {
    this.listUsaurios.listaTodosLosEmpleados().subscribe(
      (dato:any) => {
        this.usuarios = dato;
        console.log(this.usuarios);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error','Error al cargar los usaurios','error');
      }
    )

    this.dataSource = new MatTableDataSource(this.usuarios);
    console.log(this.dataSource);
      console.log("SE IMPRIMIO EL DATASOURCERE");


  }
 

  verDetallesDelEmpleado(username:string){
    console.log("enviare el detalle "+ username);
    this.router.navigate(['admin/datos_perfil',username]);
  }

  EditarDelEmpleado(username:string){
    console.log("enviare el detalle "+ username);
    this.router.navigate(['admin/actualiza_usuario',username]);
  }
  filtrar(event: Event) {
    const filtro = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filtro.trim().toLowerCase();
  } 


}

