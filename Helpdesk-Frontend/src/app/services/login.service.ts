import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject, Subscriber } from 'rxjs';
import baseUrl from './helper';
@Injectable({
  providedIn: 'root'
})
export class LoginService {


  public loginStatusSubjec = new Subject<boolean>();


  constructor(private http: HttpClient) { }



public evaluar_login(loginData:any)

{
 // console.log("ESTYOY EN EL SERVICE DE LOGIN="+`${baseUrl}/IPN/helpdesk/Usuario/Login`+" ",loginData.username,loginData.password);
 // console.log("respuesta de la BD"+this.http.get(`${baseUrl}/IPN/helpdesk/Usuario/Login`,loginData));
  console.log(this.http.get(`${baseUrl}/IPN/helpdesk/Usuario/Login`,loginData));
  return this.http.post(`${baseUrl}/IPN/helpdesk/Usuario/Login`,loginData)
}

public BuscaUsario(loginData:any)
{
  return this.http.get(`${baseUrl}/IPN/helpdesk/Usuario/userName/${loginData.username}`,loginData.usarname)

}  

public SAVE_LOCAL_STORAGE_USER (loginData:any){
  this.http.get(`${baseUrl}/IPN/helpdesk/Usuario/userName/${loginData.username}`,loginData.usarname).subscribe(
    (data:any)=> {
     // console.log("guarde en local store informacion");
    
      localStorage.setItem('username_front',JSON.stringify(data.username));
      localStorage.setItem('perfil_front',JSON.stringify(data.perfil.id_per));
      localStorage.setItem('zonaEconomica',JSON.stringify(data.zonaestados.id_zon));
      localStorage.setItem('id_user_front',JSON.stringify(data.id_user));

      return true;
    }
  )
}


public esta_concectado(){
  let id_user_fro = localStorage.getItem('id_user_front');
  if(id_user_fro == undefined || id_user_fro == '' || id_user_fro == null){
    return false;
  }else{
    return true;
  }
}

 //obtenemos usuario 
 public getusarname_storage(){
  return  localStorage.getItem('id_user_front');
 
}

public getzonaEconomica_storage(){
  return JSON.parse(localStorage.getItem('zonaEconomica'));
 
}
public getperfil_storage(){
  return JSON.parse(localStorage.getItem('perfil_front'));
}

//obtenemos id_user
public getiduser_storage(){
  return JSON.parse(localStorage.getItem('username_front'));
}

//cerranis sesion y eliminamos el token del localStorage
public logout(){
  localStorage.removeItem('id_user_front');
  localStorage.removeItem('username_front');
  localStorage.removeItem('perfil_front');
  return true;

}
public getUser(){
    
  let userStr = localStorage.getItem('perfil_front');
  if(userStr != null){
    console.log("info del perfil del usuario en el storage" +userStr)
    return JSON.parse(userStr);
  }else{
    this.logout();
    return null;
  }
}

public getUsername(){
    
  let userStr = localStorage.getItem('username_front');
  if(userStr != null){
    return JSON.parse(userStr);
  }else{
    this.logout();
    return null;
  }
}


public getUserRole(){
  let user = this.getUser();
  return user;
}

}
