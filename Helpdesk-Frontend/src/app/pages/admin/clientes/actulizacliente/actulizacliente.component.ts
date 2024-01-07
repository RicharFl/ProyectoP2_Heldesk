import  Swal  from 'sweetalert2';
import { ActivatedRoute, Router } from '@angular/router';
import { CuentaDependenciaService } from './../../../../services/cuenta-dependencia.service';
import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-actulizacliente',
  templateUrl: './actulizacliente.component.html',
  styleUrls: ['./actulizacliente.component.css']
})
export class ActulizaclienteComponent implements OnInit {
  Cliente: any = null;
  Cuenta: any=null;
  snack: any;
  dataCliente={
    "id_cliente": '',
    "nombre_cli": '10',
  }
  constructor(
    private cuentaSer: CuentaDependenciaService, 
    private router: Router,
    private route: ActivatedRoute,
    private clientesServ: ClienteService
    ) { }
  ngOnInit(): void {
    if (this.route.snapshot.params['idcliente'] != undefined) {
      this.dataCliente.id_cliente = this.route.snapshot.params['idcliente'];
    }
    else {
      this.router.navigate(['admin/clientes']);
    }

    this.clientesServ.ListaClientesId(this.dataCliente).subscribe(
      (data: any) => {
        this.Cliente = data;
      },
      (error) => {
        alert("error");
      }
    )

    this.cuentaSer.ListaTodasCuentasDependencias().subscribe(
      (data: any) => {
        this.Cuenta = data;
      },
      (error) => {
        alert("error");
      }
    )
  }

  onSubmit(): void {
    this.Cliente.last_update_date=Date.now();
  
    this.clientesServ.ActualizaElCliente(this.Cliente).subscribe(
      (data) => {
        //console.log(data);
        Swal.fire('Cliente Actulizado', 'Cliente '+this.Cliente.nombre_cli +' '+this.Cliente.apellidoP_cli +' ha sido egistrado con exito en el sistema', 'success');
        this.router.navigate(['admin/clientes']);
     
        
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )
  }




}
