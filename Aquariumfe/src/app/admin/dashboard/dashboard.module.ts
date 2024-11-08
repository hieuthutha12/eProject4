import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component'; 
import { SidebarComponent } from './sidebar/sidebar.component';
import { EventRoutingModule } from './event/event-routing.module';
import { ProfileRoutingModule } from './profile/profile-routing.module';
import { OrderRoutingModule } from './order/order-routing.module';
import { AquaticCreaturesRoutingModule } from './aquatic-creatures/aquatic-creatures-routing.module';
import { SpeciesComponent } from './species/species.component';
import { FormsModule } from '@angular/forms';
import { TypeComponent } from './type/type.component';
import { CustomerComponent } from './customer/customer.component';
import { GetProfileComponent } from './profile/get-profile/get-profile.component';


@NgModule({
  declarations: [
    DashboardComponent,
    SidebarComponent,
    SpeciesComponent,
    TypeComponent,
    CustomerComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    DashboardRoutingModule,
    EventRoutingModule,
    ProfileRoutingModule,
    OrderRoutingModule,
    AquaticCreaturesRoutingModule,
  ]
})
export class DashboardModule { }
