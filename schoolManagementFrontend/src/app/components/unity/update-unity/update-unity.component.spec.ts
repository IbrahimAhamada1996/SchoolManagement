import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateUnityComponent } from './update-unity.component';

describe('UpdateUnityComponent', () => {
  let component: UpdateUnityComponent;
  let fixture: ComponentFixture<UpdateUnityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateUnityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateUnityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
