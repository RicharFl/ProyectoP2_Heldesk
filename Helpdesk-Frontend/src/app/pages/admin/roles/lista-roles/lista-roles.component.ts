import  Swal  from 'sweetalert2';
import { ExportarAExcelService } from 'src/app/services/exportar-aexcel.service';
import { Router } from '@angular/router';
import { RolesService } from './../../../../services/roles.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-roles',
  templateUrl: './lista-roles.component.html',
  styleUrls: ['./lista-roles.component.css']
})
export class ListaRolesComponent implements OnInit{
  Roles: any = null;
  pagina!: number;
  filterPost = '';

  constructor(
    private Rolservice: RolesService, 
    private router: Router, 
    private exportecxel: ExportarAExcelService
    ) { }



  ngOnInit(): void {
    this.Rolservice.ListaTodosLosRoles().subscribe(
      (dato: any) => {
        this.Roles = dato;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error', 'Error al cargar los Roles', 'error');
      }
    )
  }


  EditarRol(idRol: string) {
    //console.log("enviare el detalle " + username);
    this.router.navigate(['admin/roles/edita/', idRol]);
  }
  
  
  exportarExcel(): void {
    this.exportecxel.exportHaExcel(this.Roles, 'Roles');
  }
  

}
