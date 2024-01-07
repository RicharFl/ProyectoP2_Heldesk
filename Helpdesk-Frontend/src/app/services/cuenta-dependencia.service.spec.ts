import { TestBed } from '@angular/core/testing';

import { CuentaDependenciaService } from './cuenta-dependencia.service';

describe('CuentaDependenciaService', () => {
  let service: CuentaDependenciaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CuentaDependenciaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
