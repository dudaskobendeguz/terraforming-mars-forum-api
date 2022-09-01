import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayersIconComponent } from './players-icon.component';

describe('PlayersIconComponent', () => {
  let component: PlayersIconComponent;
  let fixture: ComponentFixture<PlayersIconComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayersIconComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlayersIconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
