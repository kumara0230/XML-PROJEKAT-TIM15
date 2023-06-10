import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PronalazacPatentDetailsComponent } from './pronalazac-patent-details.component';

describe('PronalazacPatentDetailsComponent', () => {
  let component: PronalazacPatentDetailsComponent;
  let fixture: ComponentFixture<PronalazacPatentDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PronalazacPatentDetailsComponent]
    });
    fixture = TestBed.createComponent(PronalazacPatentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
