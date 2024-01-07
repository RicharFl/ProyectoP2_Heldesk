import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaRolesComponent } from './crea-roles.component';

describe('CreaRolesComponent', () => {
  let component: CreaRolesComponent;
  let fixture: ComponentFixture<CreaRolesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaRolesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreaRolesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
