import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaguePostDetailComponent } from './league-post-detail.component';

describe('LeaguePostDetailComponent', () => {
  let component: LeaguePostDetailComponent;
  let fixture: ComponentFixture<LeaguePostDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaguePostDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeaguePostDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
