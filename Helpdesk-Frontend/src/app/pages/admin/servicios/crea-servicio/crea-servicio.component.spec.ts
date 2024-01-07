import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaServicioComponent } from './crea-servicio.component';

describe('CreaServicioComponent', () => {
  let component: CreaServicioComponent;
  let fixture: ComponentFixture<CreaServicioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaServicioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreaServicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
