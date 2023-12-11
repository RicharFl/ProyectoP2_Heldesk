import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocTicketComponent } from './doc-ticket.component';

describe('DocTicketComponent', () => {
  let component: DocTicketComponent;
  let fixture: ComponentFixture<DocTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocTicketComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
