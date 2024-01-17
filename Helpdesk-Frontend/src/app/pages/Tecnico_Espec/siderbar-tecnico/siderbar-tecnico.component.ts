import { LoginService } from 'src/app/services/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-siderbar-tecnico',
  templateUrl: './siderbar-tecnico.component.html',
  styleUrls: ['./siderbar-tecnico.component.css']
})
export class SiderbarTecnicoComponent implements OnInit{
  constructor(public login:LoginService) { }

  ngOnInit(): void {

  }
  public logout(){
    this.login.logout();
    window.location.reload();
  }

}
