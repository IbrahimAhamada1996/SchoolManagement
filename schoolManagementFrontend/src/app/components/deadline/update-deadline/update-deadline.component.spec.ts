import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDeadlineComponent } from './update-deadline.component';

describe('UpdateDeadlineComponent', () => {
  let component: UpdateDeadlineComponent;
  let fixture: ComponentFixture<UpdateDeadlineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateDeadlineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDeadlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
