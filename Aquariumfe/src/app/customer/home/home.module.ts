import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage/homepage.component';
import { EventRoutingModule } from './event/event-routing.module';
import { HomeComponent } from './home.component';
import { AnimalModule } from './animal/animal.module';
import { FormsModule } from '@angular/forms';
import { TicketOneComponent } from './ticket/ticket-one/ticket-one.component';
import { TicketTwoComponent } from './ticket/ticket-two/ticket-two.component';
import { TicketThreeComponent } from './ticket/ticket-three/ticket-three.component';
import { TicketFourComponent } from './ticket/ticket-four/ticket-four.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { VisitComponent } from './visit/visit.component';




@NgModule({
  declarations: [
    FooterComponent,
    HeaderComponent,
    HomepageComponent,
    HomeComponent,
    FeedbackComponent,
    VisitComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    EventRoutingModule,
    AnimalModule
  ]
})
export class HomeModule { }
