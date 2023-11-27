import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizaEmpleadoAdminComponent } from './actualiza-empleado-admin.component';

describe('ActualizaEmpleadoAdminComponent', () => {
  let component: ActualizaEmpleadoAdminComponent;
  let fixture: ComponentFixture<ActualizaEmpleadoAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizaEmpleadoAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualizaEmpleadoAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
