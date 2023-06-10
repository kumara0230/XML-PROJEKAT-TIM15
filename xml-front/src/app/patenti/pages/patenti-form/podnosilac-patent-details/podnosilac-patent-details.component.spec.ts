import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PodnosilacPatentDetailsComponent } from './podnosilac-patent-details.component';

describe('PodnosilacPatentDetailsComponent', () => {
  let component: PodnosilacPatentDetailsComponent;
  let fixture: ComponentFixture<PodnosilacPatentDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PodnosilacPatentDetailsComponent]
    });
    fixture = TestBed.createComponent(PodnosilacPatentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
