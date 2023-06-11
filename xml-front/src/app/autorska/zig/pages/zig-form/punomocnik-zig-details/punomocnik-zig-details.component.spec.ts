import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PunomocnikZigDetailsComponent } from './punomocnik-zig-details.component';

describe('PunomocnikZigDetailsComponent', () => {
  let component: PunomocnikZigDetailsComponent;
  let fixture: ComponentFixture<PunomocnikZigDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PunomocnikZigDetailsComponent]
    });
    fixture = TestBed.createComponent(PunomocnikZigDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
