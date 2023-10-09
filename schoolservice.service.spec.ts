import { TestBed } from '@angular/core/testing';

import { SchoolserviceService } from './schoolservice.service';

describe('SchoolserviceService', () => {
  let service: SchoolserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SchoolserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
