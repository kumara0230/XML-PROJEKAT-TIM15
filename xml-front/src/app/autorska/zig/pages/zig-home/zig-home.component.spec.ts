import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZigHomeComponent } from './zig-home.component';

describe('ZigHomeComponent', () => {
  let component: ZigHomeComponent;
  let fixture: ComponentFixture<ZigHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ZigHomeComponent]
    });
    fixture = TestBed.createComponent(ZigHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
