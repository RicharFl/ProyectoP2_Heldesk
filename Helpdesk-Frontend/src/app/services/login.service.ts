import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import baseUrl from './helper';
@Injectable({
  providedIn: 'root'
})
export class LoginService {


  public loginStatusSubjec = new Subject<boolean>();


  constructor(private http: HttpClient) { }

  public getSHA256(LoginData: any) {
    return this.http.get(`${baseUrl}/IPN/helpdesk/Usuario/SHA256`, LoginData)
  }


  



}
