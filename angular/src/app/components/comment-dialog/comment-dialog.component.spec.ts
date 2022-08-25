import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentDialog } from './comment-dialog.component';

describe('CommentFormComponent', () => {
  let component: CommentDialog;
  let fixture: ComponentFixture<CommentDialog>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommentDialog ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CommentDialog);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
