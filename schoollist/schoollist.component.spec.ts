import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchoollistComponent } from './schoollist.component';

describe('SchoollistComponent', () => {
  let component: SchoollistComponent;
  let fixture: ComponentFixture<SchoollistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SchoollistComponent]
    });
    fixture = TestBed.createComponent(SchoollistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
