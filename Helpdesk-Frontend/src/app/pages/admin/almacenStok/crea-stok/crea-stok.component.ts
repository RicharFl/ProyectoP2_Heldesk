import  Swal  from 'sweetalert2';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { AlmacenService } from './../../../../services/almacen.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crea-stok',
  templateUrl: './crea-stok.component.html',
  styleUrls: ['./crea-stok.component.css']
})
export class CreaStokComponent implements OnInit{
  
  public Almacen_save = {

    marca: '',
    stoc: '',
    descripcin: '',
    moedelo: '',
    register_date: Date.now(),
   last_update_date :Date.now() ,  
  }


  constructor(
    private snack: MatSnackBar,
    private Almacenser:AlmacenService,
    private router: Router,
    private loginser: LoginService) { }
    
    ngOnInit(): void {
  
  };
  formSubmit() {
    if (this.Almacen_save.marca == '' || this.Almacen_save.marca  == null) {
      this.snack.open('Se requiere la Marca del Producto !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }
    if (this.Almacen_save.moedelo  == '' || this.Almacen_save.moedelo  == null) {
      this.snack.open('Se requiere la MOdelo del Producto !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }
    if (this.Almacen_save.stoc == '' || this.Almacen_save.stoc == null) {
      this.snack.open('Se requiere Numero de Productos !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }

    this.Almacenser.CrearProductoAlmacen(this.Almacen_save).subscribe(
      (data:any) =>{
        Swal.fire('Producto  Creado', 'Producto registrado con exito en el sistema', 'success');
        //this.router.navigate(['admin/clientes']);
        if (this.loginser.getUser()=='1')
        {this.router.navigate(['admin/Almacen-Stock']);}
        else if (this.loginser.getUser()=='2')
        {this.router.navigate(['gerente_general/Almacen-Stock']);}

      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )


  }
}
