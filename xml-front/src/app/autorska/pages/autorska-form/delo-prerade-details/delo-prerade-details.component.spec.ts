import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeloPreradeDetailsComponent } from './delo-prerade-details.component';

describe('DeloPreradeDetailsComponent', () => {
  let component: DeloPreradeDetailsComponent;
  let fixture: ComponentFixture<DeloPreradeDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeloPreradeDetailsComponent]
    });
    fixture = TestBed.createComponent(DeloPreradeDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
