import { TestBed } from '@angular/core/testing';

import { AsignarTicketService } from './asignar-ticket.service';

describe('AsignarTicketService', () => {
  let service: AsignarTicketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AsignarTicketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
