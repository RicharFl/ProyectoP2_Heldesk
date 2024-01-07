import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterClientes'
})
export class FilterClientesPipe implements PipeTransform {

  transform(value: any, arg: any): any {
    if (arg === '' || arg.length < 1) return value;
    const resultPosts = [];
   
    for ( const post of value) {
     // console.log(post);
      //console.log("hola"+arg.toLowerCase());
      if (((post.id_cliente +" "+post.nombre_cli+" "+post.apellidoP_cli+ 
      post.apellidoM_cli + post.correo_cli + post.cuenta.nombre_cuen + post.area_cli + post.adscrp_cli ).toLowerCase().indexOf(arg.toLowerCase()) > -1)   ) {
        resultPosts.push(post);
      };
    };
    return resultPosts;
  }


}
