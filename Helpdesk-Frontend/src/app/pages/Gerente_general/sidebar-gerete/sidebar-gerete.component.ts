import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidebar-gerete',
  templateUrl: './sidebar-gerete.component.html',
  styleUrls: ['./sidebar-gerete.component.css']
})
export class SidebarGereteComponent implements OnInit{
  constructor(public login:LoginService) { }

  ngOnInit(): void {

  }
  public logout(){
    this.login.logout();
    window.location.reload();
  }


}
