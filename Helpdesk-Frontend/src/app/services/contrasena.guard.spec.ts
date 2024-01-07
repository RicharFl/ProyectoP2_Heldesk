import { TestBed } from '@angular/core/testing';

import { ContrasenaGuard } from './contrasena.guard';

describe('ContrasenaGuard', () => {
  let guard: ContrasenaGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ContrasenaGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
