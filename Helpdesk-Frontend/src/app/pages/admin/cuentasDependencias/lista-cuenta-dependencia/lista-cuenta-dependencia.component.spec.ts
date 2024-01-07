import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCuentaDependenciaComponent } from './lista-cuenta-dependencia.component';

describe('ListaCuentaDependenciaComponent', () => {
  let component: ListaCuentaDependenciaComponent;
  let fixture: ComponentFixture<ListaCuentaDependenciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaCuentaDependenciaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaCuentaDependenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
