import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaStokComponent } from './crea-stok.component';

describe('CreaStokComponent', () => {
  let component: CreaStokComponent;
  let fixture: ComponentFixture<CreaStokComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaStokComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreaStokComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
