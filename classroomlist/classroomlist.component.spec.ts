import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassroomlistComponent } from './classroomlist.component';

describe('ClassroomlistComponent', () => {
  let component: ClassroomlistComponent;
  let fixture: ComponentFixture<ClassroomlistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClassroomlistComponent]
    });
    fixture = TestBed.createComponent(ClassroomlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
