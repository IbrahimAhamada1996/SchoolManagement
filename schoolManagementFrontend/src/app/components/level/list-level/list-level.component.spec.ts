import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListLevelComponent } from './list-level.component';

describe('ListLevelComponent', () => {
  let component: ListLevelComponent;
  let fixture: ComponentFixture<ListLevelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListLevelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListLevelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
