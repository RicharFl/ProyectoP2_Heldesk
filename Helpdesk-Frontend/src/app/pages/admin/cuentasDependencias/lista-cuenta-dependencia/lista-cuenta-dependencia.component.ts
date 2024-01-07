import  Swal  from 'sweetalert2';
import { CuentaDependenciaService } from './../../../../services/cuenta-dependencia.service';

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExportarAExcelService } from 'src/app/services/exportar-aexcel.service';

@Component({
  selector: 'app-lista-cuenta-dependencia',
  templateUrl: './lista-cuenta-dependencia.component.html',
  styleUrls: ['./lista-cuenta-dependencia.component.css']
})
export class ListaCuentaDependenciaComponent implements OnInit{

  cuenta: any = null;
  pagina!: number;
  filterPost = '';

  constructor(
    private cuentaServices: CuentaDependenciaService, 
    private router: Router, 
    private exportecxel: ExportarAExcelService
    ) { }
  ngOnInit(): void {
    this.cuentaServices.ListaTodasCuentasDependencias().subscribe(
      (dato: any) => {
        this.cuenta = dato;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error', 'Error al cargar los Roles', 'error');
      }
    )
  }

  EditarCuenta(idcuenta: string) {
    //console.log("enviare el detalle " + username);
    this.router.navigate(['admin/cuentas_dependencia/edita/', idcuenta]);
  }
  
  
  exportarExcel(): void {
    this.exportecxel.exportHaExcel(this.cuenta, 'Cuenta');
  }


}
