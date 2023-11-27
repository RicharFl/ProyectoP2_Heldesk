import { LoginService } from './login.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlmacenGuard implements CanActivate {
  constructor(private loginService:LoginService,private router:Router){

  }
  
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.loginService.esta_concectado() && this.loginService.getUserRole() == '6'){
        return true;
      }
  
      this.router.navigate(['login']);
      return false;
    
  }
  
}
