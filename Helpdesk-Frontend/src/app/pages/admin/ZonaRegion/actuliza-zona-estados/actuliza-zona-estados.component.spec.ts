import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActulizaZonaEstadosComponent } from './actuliza-zona-estados.component';

describe('ActulizaZonaEstadosComponent', () => {
  let component: ActulizaZonaEstadosComponent;
  let fixture: ComponentFixture<ActulizaZonaEstadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActulizaZonaEstadosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActulizaZonaEstadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
