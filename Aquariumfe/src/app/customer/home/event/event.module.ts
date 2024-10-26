import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventPageComponent } from './event-page/event-page.component';
import { EventDetailPageComponent } from './event-detail-page/event-detail-page.component';



@NgModule({
  declarations: [
    EventPageComponent,
    EventDetailPageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class EventModule { }
