import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeteteFacultyComponent } from './detete-faculty.component';

describe('DeteteFacultyComponent', () => {
  let component: DeteteFacultyComponent;
  let fixture: ComponentFixture<DeteteFacultyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeteteFacultyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeteteFacultyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
