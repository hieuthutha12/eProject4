import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketFourComponent } from './ticket-four.component';

describe('TicketFourComponent', () => {
  let component: TicketFourComponent;
  let fixture: ComponentFixture<TicketFourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TicketFourComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TicketFourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
