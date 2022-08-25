import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaguePotsDetailComponent } from './league-pots-detail.component';

describe('LeaguePotsDetailComponent', () => {
  let component: LeaguePotsDetailComponent;
  let fixture: ComponentFixture<LeaguePotsDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaguePotsDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeaguePotsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
