import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSchoolCareerComponent } from './add-school-career.component';

describe('AddSchoolCareerComponent', () => {
  let component: AddSchoolCareerComponent;
  let fixture: ComponentFixture<AddSchoolCareerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSchoolCareerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSchoolCareerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
