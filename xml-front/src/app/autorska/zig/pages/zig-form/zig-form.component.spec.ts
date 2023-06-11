import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZigFormComponent } from './zig-form.component';

describe('ZigFormComponent', () => {
  let component: ZigFormComponent;
  let fixture: ComponentFixture<ZigFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ZigFormComponent]
    });
    fixture = TestBed.createComponent(ZigFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
