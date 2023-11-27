import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {


  esta_concectado = false;
  user:any = null;
  constructor(public login:LoginService){

  }
  loginData_nuevi = {
    "username": '',
    "password": '10',
  }


  ngOnInit(): void {
    this.esta_concectado = this.login.esta_concectado();
    //this.user = this.login.getUsername();
    this.login.loginStatusSubjec.asObservable().subscribe(
      data => {
        this.esta_concectado = this.login.esta_concectado();
      //  this.user = this.login.getUsername();
      }
    )



    this.loginData_nuevi.username= this.login.getUsername();
    this.login.BuscaUsario(this.loginData_nuevi).subscribe(
      (data:any) => {
        this.user = data;
      },
      (error) => {
        alert("error");
      }
    )


  }
 public logout()
 {
  this.login.logout();
  window.location.reload();

 }


}
