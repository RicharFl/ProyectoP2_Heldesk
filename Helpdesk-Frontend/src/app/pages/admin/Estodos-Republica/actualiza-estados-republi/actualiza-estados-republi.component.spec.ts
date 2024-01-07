import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizaEstadosRepubliComponent } from './actualiza-estados-republi.component';

describe('ActualizaEstadosRepubliComponent', () => {
  let component: ActualizaEstadosRepubliComponent;
  let fixture: ComponentFixture<ActualizaEstadosRepubliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizaEstadosRepubliComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActualizaEstadosRepubliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
