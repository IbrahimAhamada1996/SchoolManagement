import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateGradeComponent } from './update-grade.component';

describe('UpdateGradeComponent', () => {
  let component: UpdateGradeComponent;
  let fixture: ComponentFixture<UpdateGradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateGradeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
