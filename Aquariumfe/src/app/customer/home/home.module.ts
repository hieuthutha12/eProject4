import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage/homepage.component';
import { EventRoutingModule } from './event/event-routing.module';
import { HomeComponent } from './home.component';
import { AnimalComponent } from './animal/animal.component';
import { AnimalsComponent } from './animals/animals.component';




@NgModule({
  declarations: [
    FooterComponent,
    HeaderComponent,
    HomepageComponent,
    HomeComponent,
    AnimalComponent,
    AnimalsComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    EventRoutingModule
  ]
})
export class HomeModule { }
