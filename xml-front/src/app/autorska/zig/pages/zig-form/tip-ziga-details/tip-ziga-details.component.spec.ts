import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipZigaDetailsComponent } from './tip-ziga-details.component';

describe('TipZigaDetailsComponent', () => {
  let component: TipZigaDetailsComponent;
  let fixture: ComponentFixture<TipZigaDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TipZigaDetailsComponent]
    });
    fixture = TestBed.createComponent(TipZigaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
