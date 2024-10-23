import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListOrderComponent } from './list-order/list-order.component';
import { OrderDetailsComponent } from './order-details/order-details.component';

const routes: Routes = [
  { path: 'list', component: ListOrderComponent },
  { path: 'details/:id', component: OrderDetailsComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrderRoutingModule {}
