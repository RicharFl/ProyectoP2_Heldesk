import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActulizaStokComponent } from './actuliza-stok.component';

describe('ActulizaStokComponent', () => {
  let component: ActulizaStokComponent;
  let fixture: ComponentFixture<ActulizaStokComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActulizaStokComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActulizaStokComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
