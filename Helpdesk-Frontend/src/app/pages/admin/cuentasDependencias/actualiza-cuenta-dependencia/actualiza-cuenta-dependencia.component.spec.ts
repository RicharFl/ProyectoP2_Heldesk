import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizaCuentaDependenciaComponent } from './actualiza-cuenta-dependencia.component';

describe('ActualizaCuentaDependenciaComponent', () => {
  let component: ActualizaCuentaDependenciaComponent;
  let fixture: ComponentFixture<ActualizaCuentaDependenciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizaCuentaDependenciaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualizaCuentaDependenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
