import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaZonaEstadosComponent } from './lista-zona-estados.component';

describe('ListaZonaEstadosComponent', () => {
  let component: ListaZonaEstadosComponent;
  let fixture: ComponentFixture<ListaZonaEstadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaZonaEstadosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaZonaEstadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
