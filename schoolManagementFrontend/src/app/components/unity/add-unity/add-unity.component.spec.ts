import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUnityComponent } from './add-unity.component';

describe('AddUnityComponent', () => {
  let component: AddUnityComponent;
  let fixture: ComponentFixture<AddUnityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUnityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddUnityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
