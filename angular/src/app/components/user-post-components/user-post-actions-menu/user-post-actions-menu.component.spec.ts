import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPostActionsMenuComponent } from './user-post-actions-menu.component';

describe('UserPostActionsMenuComponent', () => {
  let component: UserPostActionsMenuComponent;
  let fixture: ComponentFixture<UserPostActionsMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserPostActionsMenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserPostActionsMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
