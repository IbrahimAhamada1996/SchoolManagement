import {TestBed} from '@angular/core/testing';

import {SchoolCareerService} from './school-career.service';

describe('SchoolCareerService', () => {
  let service: SchoolCareerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SchoolCareerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
