import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentIconComponent } from './comment-icon.component';

describe('CommentIconComponent', () => {
  let component: CommentIconComponent;
  let fixture: ComponentFixture<CommentIconComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommentIconComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CommentIconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
