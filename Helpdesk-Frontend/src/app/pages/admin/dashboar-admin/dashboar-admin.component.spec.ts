import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboarAdminComponent } from './dashboar-admin.component';

describe('DashboarAdminComponent', () => {
  let component: DashboarAdminComponent;
  let fixture: ComponentFixture<DashboarAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboarAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboarAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
