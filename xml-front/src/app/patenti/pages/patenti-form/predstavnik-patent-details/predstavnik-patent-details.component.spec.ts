import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PredstavnikPatentDetailsComponent } from './predstavnik-patent-details.component';

describe('PredstavnikPatentDetailsComponent', () => {
  let component: PredstavnikPatentDetailsComponent;
  let fixture: ComponentFixture<PredstavnikPatentDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PredstavnikPatentDetailsComponent]
    });
    fixture = TestBed.createComponent(PredstavnikPatentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
