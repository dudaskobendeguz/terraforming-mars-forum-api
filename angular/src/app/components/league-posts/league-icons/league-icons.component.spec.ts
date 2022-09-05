import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeagueIconsComponent } from './league-icons.component';

describe('LeagueIconsComponent', () => {
  let component: LeagueIconsComponent;
  let fixture: ComponentFixture<LeagueIconsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeagueIconsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeagueIconsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
