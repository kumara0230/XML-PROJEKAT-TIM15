import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResenjeModalComponent } from './resenje-modal.component';

describe('ResenjeModalComponent', () => {
  let component: ResenjeModalComponent;
  let fixture: ComponentFixture<ResenjeModalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResenjeModalComponent]
    });
    fixture = TestBed.createComponent(ResenjeModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
