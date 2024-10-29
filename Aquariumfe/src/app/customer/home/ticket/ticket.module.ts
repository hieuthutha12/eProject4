import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TicketOneComponent } from './ticket-one/ticket-one.component';
import { TicketTwoComponent } from './ticket-two/ticket-two.component';
import { TicketThreeComponent } from './ticket-three/ticket-three.component';
import { TicketFourComponent } from './ticket-four/ticket-four.component';
import { FormsModule } from '@angular/forms';
import { TicketRoutingModule } from './ticket-routing.module';



@NgModule({
  declarations: [
    TicketOneComponent,
    TicketTwoComponent,
    TicketThreeComponent,
    TicketFourComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    TicketRoutingModule
  ]
})
export class TicketModule { }
