import { TestBed } from '@angular/core/testing';

import { ZonaestadosService } from './zonaestados.service';

describe('ZonaestadosService', () => {
  let service: ZonaestadosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZonaestadosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
