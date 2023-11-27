import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarUserAdminComponent } from './agregar-user-admin.component';

describe('AgregarUserAdminComponent', () => {
  let component: AgregarUserAdminComponent;
  let fixture: ComponentFixture<AgregarUserAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgregarUserAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgregarUserAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
