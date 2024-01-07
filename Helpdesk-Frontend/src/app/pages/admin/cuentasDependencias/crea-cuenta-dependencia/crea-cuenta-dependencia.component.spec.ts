import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaCuentaDependenciaComponent } from './crea-cuenta-dependencia.component';

describe('CreaCuentaDependenciaComponent', () => {
  let component: CreaCuentaDependenciaComponent;
  let fixture: ComponentFixture<CreaCuentaDependenciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaCuentaDependenciaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreaCuentaDependenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
