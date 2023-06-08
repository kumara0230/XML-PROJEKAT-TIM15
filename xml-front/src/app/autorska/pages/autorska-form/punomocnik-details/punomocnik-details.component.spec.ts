import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PunomocnikDetailsComponent } from './punomocnik-details.component';

describe('PunomocnikDetailsComponent', () => {
  let component: PunomocnikDetailsComponent;
  let fixture: ComponentFixture<PunomocnikDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PunomocnikDetailsComponent]
    });
    fixture = TestBed.createComponent(PunomocnikDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
