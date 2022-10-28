import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteDeadlineComponent } from './delete-deadline.component';

describe('DeleteDeadlineComponent', () => {
  let component: DeleteDeadlineComponent;
  let fixture: ComponentFixture<DeleteDeadlineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteDeadlineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteDeadlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
