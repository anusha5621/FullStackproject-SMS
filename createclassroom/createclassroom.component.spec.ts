import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateclassroomComponent } from './createclassroom.component';

describe('CreateclassroomComponent', () => {
  let component: CreateclassroomComponent;
  let fixture: ComponentFixture<CreateclassroomComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateclassroomComponent]
    });
    fixture = TestBed.createComponent(CreateclassroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
