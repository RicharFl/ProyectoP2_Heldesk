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


  ngOnInit(): void {
    this.esta_concectado = this.login.esta_concectado();
    this.user = this.login.getUsername();
    this.login.loginStatusSubjec.asObservable().subscribe(
      data => {
        this.esta_concectado = this.login.esta_concectado();
        this.user = this.login.getUsername();
      }
    )
  }
 public logout()
 {
  this.login.logout();
  window.location.reload();

 }


}
