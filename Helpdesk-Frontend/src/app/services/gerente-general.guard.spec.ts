import { TestBed } from '@angular/core/testing';

import { GerenteGeneralGuard } from './gerente-general.guard';

describe('GerenteGeneralGuard', () => {
  let guard: GerenteGeneralGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(GerenteGeneralGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
