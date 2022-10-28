import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteInscriptionComponent } from './delete-inscription.component';

describe('DeleteInscriptionComponent', () => {
  let component: DeleteInscriptionComponent;
  let fixture: ComponentFixture<DeleteInscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteInscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
