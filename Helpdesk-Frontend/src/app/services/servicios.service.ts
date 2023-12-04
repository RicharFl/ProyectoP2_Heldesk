import { Subject } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class ServiciosService {

  constructor(private http: HttpClient) { }



  public ListaTodosLosServicios() {
    return this.http.get(`${baseUrl}/IPN/helpdesk/Servicios/`)
  }

  public ActualizaElServicios(servicios: any) {
    return this.http.put(`${baseUrl}/IPN/helpdesk/Servicios/`, servicios)
  }
}
