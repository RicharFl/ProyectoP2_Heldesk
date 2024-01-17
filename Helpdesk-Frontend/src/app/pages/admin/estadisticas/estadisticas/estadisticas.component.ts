import { Component } from '@angular/core';
import { Color, ScaleType } from '@swimlane/ngx-charts';
import { multi } from './data';
@Component({
  selector: 'app-estadisticas',
  templateUrl: './estadisticas.component.html',
  styleUrls: ['./estadisticas.component.css']
})
export class EstadisticasComponent {
  multi: any[];
  view: [number, number] = [1000, 300];
  view2: [number, number] = [800, 200];
  view3: [number, number] = [500, 300];
  single = [
    {
      "name": "Mexico",
      "value": 89
    },
    {
      "name": "Oaxaca",
      "value": 50
    },
    {
      "name": "Chiapas",
      "value": 72
    },
      {
      "name": "Veracruz",
      "value": 62
    }
  ];

  // options
  showXAxis: boolean = true;
  showYAxis: boolean = true;
  gradient: boolean = false;
  showLegend: boolean = true;
  legendPosition: string = 'below';
  showXAxisLabel: boolean = true;
  yAxisLabel: string = 'Tickets';
  showYAxisLabel: boolean = true;
  xAxisLabel = 'Estados';
  isDoughnut: boolean = false;
  showLabels: boolean = true;
  //colorScheme = { domain: ['#5AA454', '#C7B42C', '#AAAAAA']
  //};

  colorScheme: Color = { 
    domain:     ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA'], 
    group: ScaleType.Ordinal, 
    selectable: true, 
    name: 'Customer Usage', 
};

  schemeType: string = 'linear';
  legendTitle: string = 'Estatus'
  constructor() {
    Object.assign(this, { multi } );
  }

  onSelect(data): void {
    console.log('Item clicked', JSON.parse(JSON.stringify(data)));
  }

  onActivate(data): void {
    console.log('Activate', JSON.parse(JSON.stringify(data)));
  }

  onDeactivate(data): void {
    console.log('Deactivate', JSON.parse(JSON.stringify(data)));
}

}
