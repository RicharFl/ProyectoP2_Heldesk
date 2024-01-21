import  Swal  from 'sweetalert2';
import { LoginService } from 'src/app/services/login.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AlmacenService } from './../../../../services/almacen.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-actuliza-stok',
  templateUrl: './actuliza-stok.component.html',
  styleUrls: ['./actuliza-stok.component.css']
})
export class ActulizaStokComponent implements OnInit {
  Almacen: any = null;
  Cuenta: any=null;
  snack: any;
  dataAlmacen={
    "id_almacen": '',
    "marca": '10',
  }
  constructor(
    private AlmacenSer: AlmacenService, 
    private router: Router,
    private route: ActivatedRoute,

    private loginser:LoginService
    ) { }
  ngOnInit(): void {
    if (this.route.snapshot.params['idstock'] != undefined) {
      this.dataAlmacen.id_almacen = this.route.snapshot.params['idstock'];
    }
    else {
      if (this.loginser.getUser()=='1')
      {this.router.navigate(['admin/Almacen-Stock']);}
      else if (this.loginser.getUser()=='6')
      {this.router.navigate(['gerente_general/Almacen-Stock']);}
    }

    this.AlmacenSer.ListaAlmacenId(this.dataAlmacen).subscribe(
      (data: any) => {
        this.Almacen = data;
      },
      (error) => {
        alert("error");
      }
    )


  }

  onSubmit(): void {
    this.Almacen.last_update_date=Date.now();
  
    this.AlmacenSer.ActualizaElAlmacen(this.Almacen).subscribe(
      (data) => {
        //console.log(data);
        Swal.fire('Cliente Actulizado', 'Cliente '+this.Almacen.modelo +'ha sido egistrado con exito en el sistema', 'success');
        if (this.loginser.getUser()=='1')
        {this.router.navigate(['admin/Almacen-Stock']);}
        else if (this.loginser.getUser()=='6')
        {this.router.navigate(['gerente_general/Almacen-Stock']);}
      
     
        
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )
  }

salir (){
  if (this.loginser.getUser()=='1')
  {this.router.navigate(['admin/Almacen-Stock']);}
  else if (this.loginser.getUser()=='6')
  {this.router.navigate(['gerente_general/Almacen-Stock']);}

}


}
