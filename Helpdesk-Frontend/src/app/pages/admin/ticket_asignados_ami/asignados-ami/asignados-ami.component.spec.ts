import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsignadosAmiComponent } from './asignados-ami.component';

describe('AsignadosAmiComponent', () => {
  let component: AsignadosAmiComponent;
  let fixture: ComponentFixture<AsignadosAmiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AsignadosAmiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AsignadosAmiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
