import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DdashboarGerenteGeneralComponent } from './ddashboar-gerente-general.component';

describe('DdashboarGerenteGeneralComponent', () => {
  let component: DdashboarGerenteGeneralComponent;
  let fixture: ComponentFixture<DdashboarGerenteGeneralComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DdashboarGerenteGeneralComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DdashboarGerenteGeneralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
