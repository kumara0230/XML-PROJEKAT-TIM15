import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PodnosilacDetailsComponent } from './podnosilac-details.component';

describe('PodnosilacDetailsComponent', () => {
  let component: PodnosilacDetailsComponent;
  let fixture: ComponentFixture<PodnosilacDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PodnosilacDetailsComponent]
    });
    fixture = TestBed.createComponent(PodnosilacDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
