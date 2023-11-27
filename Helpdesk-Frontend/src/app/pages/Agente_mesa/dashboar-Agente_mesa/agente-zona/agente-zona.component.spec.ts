import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgenteZonaComponent } from './agente-zona.component';

describe('AgenteZonaComponent', () => {
  let component: AgenteZonaComponent;
  let fixture: ComponentFixture<AgenteZonaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgenteZonaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgenteZonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
