import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActilizaRolesComponent } from './actiliza-roles.component';

describe('ActilizaRolesComponent', () => {
  let component: ActilizaRolesComponent;
  let fixture: ComponentFixture<ActilizaRolesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActilizaRolesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActilizaRolesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
