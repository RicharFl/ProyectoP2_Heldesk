import { TestBed } from '@angular/core/testing';

import { ExportarAExcelService } from './exportar-aexcel.service';

describe('ExportarAExcelService', () => {
  let service: ExportarAExcelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExportarAExcelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
