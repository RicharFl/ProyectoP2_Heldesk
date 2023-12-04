import { TestBed } from '@angular/core/testing';

import { HistorialticketService } from './historialticket.service';

describe('HistorialticketService', () => {
  let service: HistorialticketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HistorialticketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
