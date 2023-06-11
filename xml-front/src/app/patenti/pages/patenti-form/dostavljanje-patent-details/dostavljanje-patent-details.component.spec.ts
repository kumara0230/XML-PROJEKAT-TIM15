import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DostavljanjePatentDetailsComponent } from './dostavljanje-patent-details.component';

describe('DostavljanjePatentDetailsComponent', () => {
  let component: DostavljanjePatentDetailsComponent;
  let fixture: ComponentFixture<DostavljanjePatentDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DostavljanjePatentDetailsComponent]
    });
    fixture = TestBed.createComponent(DostavljanjePatentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
