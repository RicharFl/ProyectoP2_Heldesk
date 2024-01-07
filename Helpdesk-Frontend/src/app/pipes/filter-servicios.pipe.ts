import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterServicios'
})
export class FilterServiciosPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
