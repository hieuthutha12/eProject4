import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage/homepage.component';
import { EventRoutingModule } from './event/event-routing.module';
import { HomeComponent } from './home.component';
import { AnimalModule } from './animal/animal.module';
import { UserInfoComponent } from './user-info/user-info.component';




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
