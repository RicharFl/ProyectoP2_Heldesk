import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarGereteComponent } from './sidebar-gerete.component';

describe('SidebarGereteComponent', () => {
  let component: SidebarGereteComponent;
  let fixture: ComponentFixture<SidebarGereteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidebarGereteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SidebarGereteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
