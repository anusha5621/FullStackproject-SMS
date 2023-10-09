import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewclassroomComponent } from './viewclassroom.component';

describe('ViewclassroomComponent', () => {
  let component: ViewclassroomComponent;
  let fixture: ComponentFixture<ViewclassroomComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewclassroomComponent]
    });
    fixture = TestBed.createComponent(ViewclassroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
