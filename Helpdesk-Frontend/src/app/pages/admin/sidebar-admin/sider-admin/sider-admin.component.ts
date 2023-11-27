import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sider-admin',
  templateUrl: './sider-admin.component.html',
  styleUrls: ['./sider-admin.component.css']
})



export class SiderAdminComponent implements OnInit{
  constructor(public login:LoginService) { }

  ngOnInit(): void {

  }
  public logout(){
    this.login.logout();
    window.location.reload();
  }

}
