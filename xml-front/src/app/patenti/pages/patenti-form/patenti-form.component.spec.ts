import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatentiFormComponent } from './patenti-form.component';

describe('PatentiFormComponent', () => {
  let component: PatentiFormComponent;
  let fixture: ComponentFixture<PatentiFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PatentiFormComponent]
    });
    fixture = TestBed.createComponent(PatentiFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
