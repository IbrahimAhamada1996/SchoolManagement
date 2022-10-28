import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSchoolCareerComponent } from './update-school-career.component';

describe('UpdateSchoolCareerComponent', () => {
  let component: UpdateSchoolCareerComponent;
  let fixture: ComponentFixture<UpdateSchoolCareerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateSchoolCareerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateSchoolCareerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
