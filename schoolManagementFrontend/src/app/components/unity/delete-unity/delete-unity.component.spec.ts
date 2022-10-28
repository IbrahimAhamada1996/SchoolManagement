import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUnityComponent } from './delete-unity.component';

describe('DeleteUnityComponent', () => {
  let component: DeleteUnityComponent;
  let fixture: ComponentFixture<DeleteUnityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteUnityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUnityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
