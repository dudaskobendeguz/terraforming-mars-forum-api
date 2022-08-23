import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageLoggerComponent } from './message-logger.component';

describe('MessageLoggerComponent', () => {
  let component: MessageLoggerComponent;
  let fixture: ComponentFixture<MessageLoggerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MessageLoggerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MessageLoggerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
