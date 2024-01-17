import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MisTicketCerradosComponent } from './mis-ticket-cerrados.component';

describe('MisTicketCerradosComponent', () => {
  let component: MisTicketCerradosComponent;
  let fixture: ComponentFixture<MisTicketCerradosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MisTicketCerradosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MisTicketCerradosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
