import { TestBed } from '@angular/core/testing';

import { MessageLoggerService } from './message-logger.service';

describe('MessageLoggerService', () => {
  let service: MessageLoggerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MessageLoggerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
