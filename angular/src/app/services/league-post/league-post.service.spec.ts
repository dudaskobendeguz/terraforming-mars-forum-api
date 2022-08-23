import { TestBed } from '@angular/core/testing';

import { LeaguePostService } from './league-post.service';

describe('LeaguePostService', () => {
  let service: LeaguePostService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeaguePostService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
