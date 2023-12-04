import { TestBed } from '@angular/core/testing';

import { EstatustiketService } from './estatustiket.service';

describe('EstatustiketService', () => {
  let service: EstatustiketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EstatustiketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
