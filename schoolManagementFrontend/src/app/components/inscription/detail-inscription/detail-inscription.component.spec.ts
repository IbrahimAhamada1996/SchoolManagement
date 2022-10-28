import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailInscriptionComponent } from './detail-inscription.component';

describe('DetailInscriptionComponent', () => {
  let component: DetailInscriptionComponent;
  let fixture: ComponentFixture<DetailInscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailInscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
