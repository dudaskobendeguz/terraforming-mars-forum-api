import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUserPostDialogComponent } from './delete-user-post-dialog.component';

describe('DeleteUserPostDialogComponent', () => {
  let component: DeleteUserPostDialogComponent;
  let fixture: ComponentFixture<DeleteUserPostDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteUserPostDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteUserPostDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
