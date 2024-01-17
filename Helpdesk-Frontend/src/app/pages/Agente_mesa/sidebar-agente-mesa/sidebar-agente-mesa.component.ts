import { LoginService } from 'src/app/services/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar-agente-mesa',
  templateUrl: './sidebar-agente-mesa.component.html',
  styleUrls: ['./sidebar-agente-mesa.component.css']
})
export class SidebarAgenteMesaComponent implements OnInit{
  constructor(public login:LoginService) { }

  ngOnInit(): void {

  }
  public logout(){
    this.login.logout();
    window.location.reload();
  }

}
