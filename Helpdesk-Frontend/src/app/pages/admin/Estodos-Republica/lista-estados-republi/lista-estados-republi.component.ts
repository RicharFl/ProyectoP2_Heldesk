import  Swal from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EstadosrepublicaService } from 'src/app/services/estadosrepublica.service';
import { ExportarAExcelService } from 'src/app/services/exportar-aexcel.service';

@Component({
  selector: 'app-lista-estados-republi',
  templateUrl: './lista-estados-republi.component.html',
  styleUrls: ['./lista-estados-republi.component.css']
})
export class ListaEstadosRepubliComponent implements OnInit{

  EstadoRepu: any = null;
  pagina!: number;
  filterPost = '';

  constructor(
    private estadoRepublica: EstadosrepublicaService, 
    private router: Router, 
    private exportecxel: ExportarAExcelService
    ) { }
ngOnInit(): void {

this.estadoRepublica.ListaTodosLosEstadosDelaRepublica().subscribe(
  (dato: any) => {
    this.EstadoRepu = dato;
  },
  (error) => {
    console.log(error);
    Swal.fire('Error', 'Error al cargar los usaurios', 'error');
  }
)


}

EditarEstadoRepublica(idEdo: string) {
  //console.log("enviare el detalle " + username);
  this.router.navigate(['admin/estados_republica/edita/', idEdo]);
}


exportarExcel(): void {
  this.exportecxel.exportHaExcel(this.EstadoRepu, 'EstadosRepublica');
}

}
