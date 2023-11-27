import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CordinadorZonaComponent } from './cordinador-zona.component';

describe('CordinadorZonaComponent', () => {
  let component: CordinadorZonaComponent;
  let fixture: ComponentFixture<CordinadorZonaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CordinadorZonaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CordinadorZonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
