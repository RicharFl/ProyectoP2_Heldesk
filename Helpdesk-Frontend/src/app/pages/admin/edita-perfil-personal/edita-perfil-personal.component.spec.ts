import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditaPerfilPersonalComponent } from './edita-perfil-personal.component';

describe('EditaPerfilPersonalComponent', () => {
  let component: EditaPerfilPersonalComponent;
  let fixture: ComponentFixture<EditaPerfilPersonalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditaPerfilPersonalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditaPerfilPersonalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
