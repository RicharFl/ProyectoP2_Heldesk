import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MisTicketAsigandosComponent } from './mis-ticket-asigandos.component';

describe('MisTicketAsigandosComponent', () => {
  let component: MisTicketAsigandosComponent;
  let fixture: ComponentFixture<MisTicketAsigandosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MisTicketAsigandosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MisTicketAsigandosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
