import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorDetailComponent } from './error-detail.component';

describe('ErrorDetailComponent', () => {
  let component: ErrorDetailComponent;
  let fixture: ComponentFixture<ErrorDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ErrorDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErrorDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
