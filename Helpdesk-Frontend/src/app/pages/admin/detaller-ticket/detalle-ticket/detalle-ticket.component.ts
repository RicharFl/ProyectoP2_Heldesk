import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-detalle-ticket',
  templateUrl: './detalle-ticket.component.html',
  styleUrls: ['./detalle-ticket.component.css']
})
export class DetalleTicketComponent implements OnInit{
  ticket: any = null;
  ticket_data={
"id_ticket":'',
"des_error": ''
  }

  constructor(private tickets: TicketService, private route: ActivatedRoute) { }
  ngOnInit(): void {
    console.log(this.route.snapshot.params['id_ticket'] );

  }

}
