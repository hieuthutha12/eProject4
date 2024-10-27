import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home.component';
import { AnimalComponent } from './animal/animal.component';
import { AnimalsComponent } from './animals/animals.component';




@NgModule({
  declarations: [
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    AnimalComponent,
    AnimalsComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule
  ]
})
export class HomeModule { }
