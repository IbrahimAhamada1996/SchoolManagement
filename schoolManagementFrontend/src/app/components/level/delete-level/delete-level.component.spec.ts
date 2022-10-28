import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteLevelComponent } from './delete-level.component';

describe('DeleteLevelComponent', () => {
  let component: DeleteLevelComponent;
  let fixture: ComponentFixture<DeleteLevelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteLevelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteLevelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
