import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroRol'
})
export class FiltroRolPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
