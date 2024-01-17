import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaStokComponent } from './lista-stok.component';

describe('ListaStokComponent', () => {
  let component: ListaStokComponent;
  let fixture: ComponentFixture<ListaStokComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaStokComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaStokComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
