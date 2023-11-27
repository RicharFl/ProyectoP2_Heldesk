import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaEmpleadosAdminComponent } from './lista-empleados-admin.component';

describe('ListaEmpleadosAdminComponent', () => {
  let component: ListaEmpleadosAdminComponent;
  let fixture: ComponentFixture<ListaEmpleadosAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaEmpleadosAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaEmpleadosAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
