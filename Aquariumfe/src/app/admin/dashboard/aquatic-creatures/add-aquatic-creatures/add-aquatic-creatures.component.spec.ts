import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAquaticCreaturesComponent } from './add-aquatic-creatures.component';

describe('AddAquaticCreaturesComponent', () => {
  let component: AddAquaticCreaturesComponent;
  let fixture: ComponentFixture<AddAquaticCreaturesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddAquaticCreaturesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddAquaticCreaturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
