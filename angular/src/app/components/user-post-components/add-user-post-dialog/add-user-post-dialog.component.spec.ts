import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUserPostDialogComponent } from './add-user-post-dialog.component';

describe('AddUserPostDialogComponent', () => {
  let component: AddUserPostDialogComponent;
  let fixture: ComponentFixture<AddUserPostDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUserPostDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddUserPostDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
