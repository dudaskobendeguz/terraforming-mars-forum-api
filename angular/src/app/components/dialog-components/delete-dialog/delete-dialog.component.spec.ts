import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteDialog } from './delete-dialog.component';

describe('DeleteUserPostDialogComponent', () => {
  let component: DeleteDialog;
  let fixture: ComponentFixture<DeleteDialog>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteDialog ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteDialog);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
