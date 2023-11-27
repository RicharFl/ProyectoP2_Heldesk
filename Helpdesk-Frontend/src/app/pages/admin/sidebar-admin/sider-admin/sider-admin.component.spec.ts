import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SiderAdminComponent } from './sider-admin.component';

describe('SiderAdminComponent', () => {
  let component: SiderAdminComponent;
  let fixture: ComponentFixture<SiderAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SiderAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SiderAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
