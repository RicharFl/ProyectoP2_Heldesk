import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
@Injectable({
  providedIn: 'root'
})
export class EstadosrepublicaService {

  
  constructor(private http: HttpClient) { }


  public CrearEstadoDeLaRepublica (EstadoRepublica:any){
    return this.http.post(`${baseUrl}/IPN/helpdesk/EstadosRepublica/`,EstadoRepublica);
  }
public ListaTodosLosEstadosDelaRepublica (){
  return this.http.get(`${baseUrl}/IPN/helpdesk/EstadosRepublica/`)
}

public ActulizaEstadoRepublica (EstadoRepublicaca:any)
{
  return this.http.put(`${baseUrl}/IPN/helpdesk/EstadosRepublica/`,EstadoRepublicaca)
}
public BuscaEstadosDelaRepublicaPorID (dataEstado:any){
  return this.http.get(`${baseUrl}/IPN/helpdesk/EstadosRepublica/${dataEstado.id_est_repu}`,dataEstado.id_est_repu)
}


}
