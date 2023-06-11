import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzgledZnakaComponent } from './izgled-znaka.component';

describe('IzgledZnakaComponent', () => {
  let component: IzgledZnakaComponent;
  let fixture: ComponentFixture<IzgledZnakaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IzgledZnakaComponent]
    });
    fixture = TestBed.createComponent(IzgledZnakaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
