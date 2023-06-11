import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PodnosilacZigDetailsComponent } from './podnosilac-zig-details.component';

describe('PodnosilacZigDetailsComponent', () => {
  let component: PodnosilacZigDetailsComponent;
  let fixture: ComponentFixture<PodnosilacZigDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PodnosilacZigDetailsComponent]
    });
    fixture = TestBed.createComponent(PodnosilacZigDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
