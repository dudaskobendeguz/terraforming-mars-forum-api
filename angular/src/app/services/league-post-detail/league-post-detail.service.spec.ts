import { TestBed } from '@angular/core/testing';

import { LeaguePostDetailService } from './league-post-detail.service';

describe('LeaguePostDetailService', () => {
  let service: LeaguePostDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeaguePostDetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
