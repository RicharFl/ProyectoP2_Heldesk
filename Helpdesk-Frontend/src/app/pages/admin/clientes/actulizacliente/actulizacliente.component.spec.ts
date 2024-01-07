import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActulizaclienteComponent } from './actulizacliente.component';

describe('ActulizaclienteComponent', () => {
  let component: ActulizaclienteComponent;
  let fixture: ComponentFixture<ActulizaclienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActulizaclienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActulizaclienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
