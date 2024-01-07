import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-datos-perfil',
  templateUrl: './datos-perfil.component.html',
  styleUrls: ['./datos-perfil.component.css']
})





export class DatosPerfilComponent implements OnInit {
  user: any = [];


  constructor(private loginService: LoginService, private route: ActivatedRoute, private router: Router) { }
  loginData_nuevi = {
    "username": '',
    "password": '10',
  }
  username!: string; 
  ngOnInit(): void {

    console.log(this.route.snapshot.params['username'] );
    if (this.route.snapshot.params['username'] != undefined) {
      this.loginData_nuevi.username = this.route.snapshot.params['username'];     
    }
    else {
      this.loginData_nuevi.username = this.loginService.getUsername();
    }
    this.loginService.BuscaUsario(this.loginData_nuevi).subscribe(
      (data: any) => {
        this.user = data;
      },
      (error) => {
        alert("error");
      }
    )
  }

  EditarDelEmpleado(username:string){
    console.log("enviare el detalle "+ username);
    this.router.navigate(['admin/actualiza_usuario',username]);
  }



}
