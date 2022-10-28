import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSchoolCareerComponent } from './list-school-career.component';

describe('ListSchoolCareerComponent', () => {
  let component: ListSchoolCareerComponent;
  let fixture: ComponentFixture<ListSchoolCareerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListSchoolCareerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSchoolCareerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
