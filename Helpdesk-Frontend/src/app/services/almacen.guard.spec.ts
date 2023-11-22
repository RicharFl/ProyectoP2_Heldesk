import { TestBed } from '@angular/core/testing';

import { AlmacenGuard } from './almacen.guard';

describe('AlmacenGuard', () => {
  let guard: AlmacenGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AlmacenGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
