import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextareaDialogComponent } from './textarea-dialog.component';

describe('TextareaDialogComponent', () => {
  let component: TextareaDialogComponent;
  let fixture: ComponentFixture<TextareaDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TextareaDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TextareaDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
