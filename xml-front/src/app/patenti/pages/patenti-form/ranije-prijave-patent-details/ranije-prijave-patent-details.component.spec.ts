import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RanijePrijavePatentDetailsComponent } from './ranije-prijave-patent-details.component';

describe('RanijePrijavePatentDetailsComponent', () => {
  let component: RanijePrijavePatentDetailsComponent;
  let fixture: ComponentFixture<RanijePrijavePatentDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RanijePrijavePatentDetailsComponent]
    });
    fixture = TestBed.createComponent(RanijePrijavePatentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
