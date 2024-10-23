import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventRoutingModule } from './event-routing.module';
import { AddEventComponent } from './add-event/add-event.component';
import { UpdateEventComponent } from './update-event/update-event.component';
import { ListEventComponent } from './list-event/list-event.component';
import { EventFormComponent } from './event-form/event-form.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AddEventComponent,
    UpdateEventComponent,
    ListEventComponent,
    EventFormComponent
  ],
  imports: [
    CommonModule,
    EventRoutingModule,
    ReactiveFormsModule
  ]
})
export class EventModule { }
