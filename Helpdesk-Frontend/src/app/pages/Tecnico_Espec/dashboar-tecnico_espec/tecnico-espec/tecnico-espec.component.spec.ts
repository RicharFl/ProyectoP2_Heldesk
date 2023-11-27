import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TecnicoEspecComponent } from './tecnico-espec.component';

describe('TecnicoEspecComponent', () => {
  let component: TecnicoEspecComponent;
  let fixture: ComponentFixture<TecnicoEspecComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TecnicoEspecComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TecnicoEspecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
