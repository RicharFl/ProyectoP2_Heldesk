import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaEstadosRepubliComponent } from './crea-estados-republi.component';

describe('CreaEstadosRepubliComponent', () => {
  let component: CreaEstadosRepubliComponent;
  let fixture: ComponentFixture<CreaEstadosRepubliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaEstadosRepubliComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreaEstadosRepubliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
