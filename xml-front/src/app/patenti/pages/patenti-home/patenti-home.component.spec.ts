import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatentiHomeComponent } from './patenti-home.component';

describe('PatentiHomeComponent', () => {
  let component: PatentiHomeComponent;
  let fixture: ComponentFixture<PatentiHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PatentiHomeComponent]
    });
    fixture = TestBed.createComponent(PatentiHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
