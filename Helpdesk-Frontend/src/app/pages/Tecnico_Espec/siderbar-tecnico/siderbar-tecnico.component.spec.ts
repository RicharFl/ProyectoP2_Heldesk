import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SiderbarTecnicoComponent } from './siderbar-tecnico.component';

describe('SiderbarTecnicoComponent', () => {
  let component: SiderbarTecnicoComponent;
  let fixture: ComponentFixture<SiderbarTecnicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SiderbarTecnicoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SiderbarTecnicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
