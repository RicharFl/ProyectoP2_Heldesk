import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaZonaEstadosComponent } from './crea-zona-estados.component';

describe('CreaZonaEstadosComponent', () => {
  let component: CreaZonaEstadosComponent;
  let fixture: ComponentFixture<CreaZonaEstadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaZonaEstadosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreaZonaEstadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
