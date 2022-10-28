import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateModuleComponent } from './update-module.component';

describe('UpdateModuleComponent', () => {
  let component: UpdateModuleComponent;
  let fixture: ComponentFixture<UpdateModuleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateModuleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
