import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsignarTicketComponent } from './asignar-ticket.component';

describe('AsignarTicketComponent', () => {
  let component: AsignarTicketComponent;
  let fixture: ComponentFixture<AsignarTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AsignarTicketComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AsignarTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
