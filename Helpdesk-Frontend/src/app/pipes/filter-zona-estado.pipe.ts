import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterZonaEstado'
})
export class FilterZonaEstadoPipe implements PipeTransform {

  transform(value: any, arg: any): any {
    if (arg === '' || arg.length < 1) return value;
    const resultPosts = [];
   
    for ( const post of value) {
     // console.log(post);
      //console.log("hola"+arg.toLowerCase());
      if (((post.id_zon +" "+post.nombree+" "+post.descripcion+  post.last_update_date).toLowerCase().indexOf(arg.toLowerCase()) > -1)   ) {
        resultPosts.push(post);
      };
    };
    return resultPosts;
  }
}
