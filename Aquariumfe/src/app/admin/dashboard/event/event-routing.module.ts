import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEventComponent } from './add-event/add-event.component';
import { UpdateEventComponent } from './update-event/update-event.component';
import { ListEventComponent } from './list-event/list-event.component';

const routes: Routes = [
  { path: 'add', component: AddEventComponent },
  { path: 'update/:id', component: UpdateEventComponent },
  { path: 'list', component: ListEventComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EventRoutingModule {}
