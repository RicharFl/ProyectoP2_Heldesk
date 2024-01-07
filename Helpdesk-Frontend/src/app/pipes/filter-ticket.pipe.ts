import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterTicket'
})
export class FilterTicketPipe implements PipeTransform {


  transform(value: any, arg: any): any {
    if (arg === '' || arg.length < 1) return value;
    const resultPosts = [];
   
    for ( const post of value) {
     // console.log(post);
      //console.log("hola"+arg.toLowerCase());
      if (((post.cliente.cuenta.nombre_cuen +" "+post.no_serie+" "+post.servicios.nom_service+  post.id_ticket
       + post.estadosrepu.nombre_esatdo + post.estadosrepu.zona.nombree+post.status_Ticket.nom_status).toLowerCase().indexOf(arg.toLowerCase()) > -1)   ) {
        resultPosts.push(post);
      };
    };
    return resultPosts;
  }

}
