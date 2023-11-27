import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AgenteMesaGuard implements CanActivate {
 
  constructor(private loginService:LoginService,private router:Router){

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.loginService.esta_concectado() && this.loginService.getUserRole() == '4'){
        return true;
      }
      this.router.navigate(['login']);
      return false;
  }
  
}
