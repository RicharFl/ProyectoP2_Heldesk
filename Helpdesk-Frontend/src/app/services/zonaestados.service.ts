
import { Subject } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';


@Injectable({
  providedIn: 'root'
})
export class ZonaestadosService {

  constructor(private http: HttpClient) { }


  
public ListaTodosLasZonas (){
  return this.http.get(`${baseUrl}/IPN/helpdesk/ZonaEstado/`)
}

public ActulizaZonaEstados (zonas:any)
{
  return this.http.put(`${baseUrl}/IPN/helpdesk/ZonaEstado/`,zonas)
}

public CrearZonaEstado (zonas:any)
{
  return this.http.post(`${baseUrl}/IPN/helpdesk/ZonaEstado/`,zonas)
}

public ListaZonaEstadoPorId(Zona:any)
{
  return this.http.get(`${baseUrl}/IPN/helpdesk/ZonaEstado/${Zona.id_zon}`,Zona.id_zon)
}  


}
