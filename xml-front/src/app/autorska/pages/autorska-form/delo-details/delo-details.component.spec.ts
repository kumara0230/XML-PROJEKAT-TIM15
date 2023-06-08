import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeloDetailsComponent } from './delo-details.component';

describe('DeloDetailsComponent', () => {
  let component: DeloDetailsComponent;
  let fixture: ComponentFixture<DeloDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeloDetailsComponent]
    });
    fixture = TestBed.createComponent(DeloDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
