import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarCordinadorComponent } from './sidebar-cordinador.component';

describe('SidebarCordinadorComponent', () => {
  let component: SidebarCordinadorComponent;
  let fixture: ComponentFixture<SidebarCordinadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidebarCordinadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SidebarCordinadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
