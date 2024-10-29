import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TicketOneComponent } from './ticket-one/ticket-one.component';
import { TicketTwoComponent } from './ticket-two/ticket-two.component';
import { TicketThreeComponent } from './ticket-three/ticket-three.component';
import { TicketFourComponent } from './ticket-four/ticket-four.component';
const routes: Routes = [
  { path: 'one', component: TicketOneComponent },
  { path: 'two', component: TicketTwoComponent },
  { path: 'three', component: TicketThreeComponent },
  { path: 'four', component: TicketFourComponent },
  { path: '', redirectTo: 'one', pathMatch: 'full' } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TicketRoutingModule {}
