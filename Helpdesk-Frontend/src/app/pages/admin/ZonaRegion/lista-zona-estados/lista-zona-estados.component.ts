import  Swal  from 'sweetalert2';
import { Router } from '@angular/router';
import { ZonaestadosService } from 'src/app/services/zonaestados.service';
import { Component, OnInit } from '@angular/core';
import { ExportarAExcelService } from 'src/app/services/exportar-aexcel.service';

@Component({
  selector: 'app-lista-zona-estados',
  templateUrl: './lista-zona-estados.component.html',
  styleUrls: ['./lista-zona-estados.component.css']
})
export class ListaZonaEstadosComponent implements OnInit {
  ZonaEstado: any = null;
  pagina!: number;
  filterPost = '';

  constructor(
    private zonaEstados: ZonaestadosService, 
    private router: Router, 
    private exportecxel: ExportarAExcelService
    ) { }

    ngOnInit(): void {
this.zonaEstados.ListaTodosLasZonas().subscribe(
  (dato: any) => {
    this.ZonaEstado = dato;
  },
  (error) => {
    console.log(error);
    Swal.fire('Error', 'Error al cargar los zona', 'error');
  }
)

    }

    EditarZonaEstado(idZonEdo: string) {
      //console.log("enviare el detalle " + username);
      this.router.navigate(['admin/zona_estados/edita/', idZonEdo]);
    }
    
    
    exportarExcel(): void {
      this.exportecxel.exportHaExcel(this.ZonaEstado, 'EstadosRepublica');
    }
    


  }
