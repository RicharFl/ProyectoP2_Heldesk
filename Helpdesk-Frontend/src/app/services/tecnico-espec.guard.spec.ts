import { TestBed } from '@angular/core/testing';

import { TecnicoEspecGuard } from './tecnico-espec.guard';

describe('TecnicoEspecGuard', () => {
  let guard: TecnicoEspecGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(TecnicoEspecGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
