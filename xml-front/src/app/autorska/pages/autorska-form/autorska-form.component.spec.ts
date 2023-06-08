import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorskaFormComponent } from './autorska-form.component';

describe('AutorskaFormComponent', () => {
  let component: AutorskaFormComponent;
  let fixture: ComponentFixture<AutorskaFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutorskaFormComponent]
    });
    fixture = TestBed.createComponent(AutorskaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
