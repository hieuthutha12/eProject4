import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TicketOneComponent } from './ticket-one/ticket-one.component';
import { TicketTwoComponent } from './ticket-two/ticket-two.component';
import { TickThreeComponent } from './tick-three/tick-three.component';
import { TicketThreeComponent } from './ticket-three/ticket-three.component';
import { TicketFourComponent } from './ticket-four/ticket-four.component';



@NgModule({
  declarations: [
    TicketOneComponent,
    TicketTwoComponent,
    TickThreeComponent,
    TicketThreeComponent,
    TicketFourComponent
  ],
  imports: [
    CommonModule
  ]
})
export class TicketModule { }
