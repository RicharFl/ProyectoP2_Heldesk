import { TestBed } from '@angular/core/testing';

import { EstadosrepublicaService } from './estadosrepublica.service';

describe('EstadosrepublicaService', () => {
  let service: EstadosrepublicaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EstadosrepublicaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
