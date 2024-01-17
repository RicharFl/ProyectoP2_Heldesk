import { LoginService } from 'src/app/services/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar-cordinador',
  templateUrl: './sidebar-cordinador.component.html',
  styleUrls: ['./sidebar-cordinador.component.css']
})
export class SidebarCordinadorComponent implements OnInit{
  constructor(public login:LoginService) { }

  ngOnInit(): void {

  }
  public logout(){
    this.login.logout();
    window.location.reload();
  }


}
