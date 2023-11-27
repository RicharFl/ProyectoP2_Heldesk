import { TestBed } from '@angular/core/testing';

import { CordinadorZonaGuard } from './cordinador-zona.guard';

describe('CordinadorZonaGuard', () => {
  let guard: CordinadorZonaGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(CordinadorZonaGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
