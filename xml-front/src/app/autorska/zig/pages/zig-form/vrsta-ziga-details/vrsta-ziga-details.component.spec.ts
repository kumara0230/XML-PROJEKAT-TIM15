import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VrstaZigaDetailsComponent } from './vrsta-ziga-details.component';

describe('VrstaZigaDetailsComponent', () => {
  let component: VrstaZigaDetailsComponent;
  let fixture: ComponentFixture<VrstaZigaDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VrstaZigaDetailsComponent]
    });
    fixture = TestBed.createComponent(VrstaZigaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
