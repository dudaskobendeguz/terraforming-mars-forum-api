import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPostContainerComponent } from './user-post-container.component';

describe('UserPostContainerComponent', () => {
  let component: UserPostContainerComponent;
  let fixture: ComponentFixture<UserPostContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserPostContainerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserPostContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
