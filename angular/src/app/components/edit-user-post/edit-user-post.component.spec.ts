import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditUserPostComponent } from './edit-user-post.component';

describe('EditUserPostComponent', () => {
  let component: EditUserPostComponent;
  let fixture: ComponentFixture<EditUserPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditUserPostComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditUserPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
