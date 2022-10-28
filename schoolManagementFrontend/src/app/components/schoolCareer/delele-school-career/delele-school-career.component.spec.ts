import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleleSchoolCareerComponent } from './delele-school-career.component';

describe('DeleleSchoolCareerComponent', () => {
  let component: DeleleSchoolCareerComponent;
  let fixture: ComponentFixture<DeleleSchoolCareerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleleSchoolCareerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleleSchoolCareerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
