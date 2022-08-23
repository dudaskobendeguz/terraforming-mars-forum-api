import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaguePostComponent } from './league-post.component';

describe('LeaguePostComponent', () => {
  let component: LeaguePostComponent;
  let fixture: ComponentFixture<LeaguePostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaguePostComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeaguePostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
