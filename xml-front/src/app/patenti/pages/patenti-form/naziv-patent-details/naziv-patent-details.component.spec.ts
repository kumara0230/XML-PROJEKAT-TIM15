import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NazivPatentDetailsComponent } from './naziv-patent-details.component';

describe('NazivPatentDetailsComponent', () => {
  let component: NazivPatentDetailsComponent;
  let fixture: ComponentFixture<NazivPatentDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NazivPatentDetailsComponent]
    });
    fixture = TestBed.createComponent(NazivPatentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
