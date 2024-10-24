import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListEventComponent } from './list-event/list-event.component';
import { EventFormComponent } from './event-form/event-form.component';
const routes: Routes = [
  { path: 'list', component: ListEventComponent },
  { path: 'event/form', component: EventFormComponent },
  { path: 'event/form/:id', component: EventFormComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EventRoutingModule {}
