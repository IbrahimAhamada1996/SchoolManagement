import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleleEstablishmentComponent } from './delele-establishment.component';

describe('DeleleEstablishmentComponent', () => {
  let component: DeleleEstablishmentComponent;
  let fixture: ComponentFixture<DeleleEstablishmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleleEstablishmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleleEstablishmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
