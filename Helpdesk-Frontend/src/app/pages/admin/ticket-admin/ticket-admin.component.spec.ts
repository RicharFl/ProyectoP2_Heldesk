import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketAdminComponent } from './ticket-admin.component';

describe('TicketAdminComponent', () => {
  let component: TicketAdminComponent;
  let fixture: ComponentFixture<TicketAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TicketAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
