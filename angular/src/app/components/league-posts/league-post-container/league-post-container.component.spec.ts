import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaguePostContainerComponent } from './league-post-container.component';

describe('LeaguePostsComponent', () => {
  let component: LeaguePostContainerComponent;
  let fixture: ComponentFixture<LeaguePostContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaguePostContainerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeaguePostContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
