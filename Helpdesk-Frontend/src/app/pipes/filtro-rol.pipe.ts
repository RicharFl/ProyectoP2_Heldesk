import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroRol'
})
export class FiltroRolPipe implements PipeTransform {

  transform(value: any, arg: any): any {
    if (arg === '' || arg.length < 1) return value;
    const resultPosts = [];
   
    for ( const post of value) {
     // console.log(post);
      //console.log("hola"+arg.toLowerCase());
      if (((post.id_est_repu +" "+post.descripcion+" "+post.nombre_esatdo + " "+ post.zona.nombree).toLowerCase().indexOf(arg.toLowerCase()) > -1)   ) {
        resultPosts.push(post);
      };
    };
    return resultPosts;
  }


}
