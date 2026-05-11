import { TestBed } from '@angular/core/testing';

import { Assurance } from './assurance';

describe('Assurance', () => {
  let service: Assurance;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Assurance);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
