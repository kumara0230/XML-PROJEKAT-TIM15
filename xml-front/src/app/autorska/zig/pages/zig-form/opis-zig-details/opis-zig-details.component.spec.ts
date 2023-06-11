import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpisZigDetailsComponent } from './opis-zig-details.component';

describe('OpisZigDetailsComponent', () => {
  let component: OpisZigDetailsComponent;
  let fixture: ComponentFixture<OpisZigDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OpisZigDetailsComponent]
    });
    fixture = TestBed.createComponent(OpisZigDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
