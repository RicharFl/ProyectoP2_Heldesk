import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarAgenteMesaComponent } from './sidebar-agente-mesa.component';

describe('SidebarAgenteMesaComponent', () => {
  let component: SidebarAgenteMesaComponent;
  let fixture: ComponentFixture<SidebarAgenteMesaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidebarAgenteMesaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SidebarAgenteMesaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
