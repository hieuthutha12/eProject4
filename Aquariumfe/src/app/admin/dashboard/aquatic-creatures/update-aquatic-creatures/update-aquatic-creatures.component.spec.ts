import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAquaticCreaturesComponent } from './update-aquatic-creatures.component';

describe('UpdateAquaticCreaturesComponent', () => {
  let component: UpdateAquaticCreaturesComponent;
  let fixture: ComponentFixture<UpdateAquaticCreaturesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateAquaticCreaturesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateAquaticCreaturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
