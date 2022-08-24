import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditUserPostDialogComponent } from './edit-user-post-dialog.component';

describe('EditUserPostDialogComponent', () => {
  let component: EditUserPostDialogComponent;
  let fixture: ComponentFixture<EditUserPostDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditUserPostDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditUserPostDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
