import { FocusTrap } from '@angular/cdk/a11y';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {


  transform(value: any, arg: any): any {
    if (arg === '' || arg.length < 3) return value;
    const resultPosts = [];
   
    for ( const post of value) {
     // console.log(post);
      //console.log("hola"+arg.toLowerCase());
      if (((post.nombre_user+" "+post.apellidom_user+" "+post.apellidop_user ).toLowerCase().indexOf(arg.toLowerCase()) > -1)||(post.perfil.nom_per.toLowerCase().indexOf(arg.toLowerCase()) > -1) ||(post.staus_user.toLowerCase().indexOf(arg.toLowerCase()) > -1)  ) {
        resultPosts.push(post);
      };
    };
    return resultPosts;
  }

}
