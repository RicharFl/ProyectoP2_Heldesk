import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaEstadosRepubliComponent } from './lista-estados-republi.component';

describe('ListaEstadosRepubliComponent', () => {
  let component: ListaEstadosRepubliComponent;
  let fixture: ComponentFixture<ListaEstadosRepubliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaEstadosRepubliComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaEstadosRepubliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
