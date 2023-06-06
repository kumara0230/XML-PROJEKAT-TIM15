import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorskaHomeComponent } from './autorska-home.component';

describe('AutorskaHomeComponent', () => {
  let component: AutorskaHomeComponent;
  let fixture: ComponentFixture<AutorskaHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AutorskaHomeComponent]
    });
    fixture = TestBed.createComponent(AutorskaHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
