import { LoginService } from 'src/app/services/login.service';
import  Swal  from 'sweetalert2';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ClienteService } from 'src/app/services/cliente.service';
import { CuentaDependenciaService } from './../../../../services/cuenta-dependencia.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crea-cliente',
  templateUrl: './crea-cliente.component.html',
  styleUrls: ['./crea-cliente.component.css']
})
export class CreaClienteComponent implements OnInit{
  
  public Cliente_save = {
    nombre_cli: '',
    apellidoP_cli: '',
    apellidoM_cli: '',
    correo_cli: '',
    tel_cli: '',
    ext_cli: '',
    adscrp_cli: '',
    area_cli: '',
    register_date: Date.now(),
   last_update_date :Date.now() ,  
   cuenta: {id_cuen:''}
  }
  cuentadata: any=null;

  constructor(private cuentaSer : CuentaDependenciaService,
    private snack: MatSnackBar,
    private ClienteServ:ClienteService,
    private router: Router,
    private loginser: LoginService) { }
    
    ngOnInit(): void {
    this.cuentaSer.ListaTodasCuentasDependencias().subscribe(
      (data:any)=> {
       this.cuentadata=data;
      },  (error) => {
        alert("error");
      }
    )
  };
  formSubmit() {
    if (this.Cliente_save.nombre_cli == '' || this.Cliente_save.nombre_cli == null) {
      this.snack.open('Se requiere Nombre del Cliente !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }
    if (this.Cliente_save.correo_cli == '' || this.Cliente_save.correo_cli == null) {
      this.snack.open('Se requiere correo del Cliente !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }
    if (this.Cliente_save.ext_cli == '' || this.Cliente_save.ext_cli == null) {
      this.snack.open('Se requiere extension del Cliente !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }

    this.ClienteServ.CrearElCliente(this.Cliente_save).subscribe(
      (data:any) =>{
        Swal.fire('Cliente Creado', 'Cliente registrado con exito en el sistema', 'success');
        //this.router.navigate(['admin/clientes']);
        if (this.loginser.getUser()=='1')
        {this.router.navigate(['admin/clientes']);}
        else if (this.loginser.getUser()=='2')
        {this.router.navigate(['gerente_general/clientes']);}

      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )


  }
}
