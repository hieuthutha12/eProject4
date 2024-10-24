import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component'; 
import { SidebarComponent } from './sidebar/sidebar.component';
import { EventRoutingModule } from './event/event-routing.module';
import { ProfileRoutingModule } from './profile/profile-routing.module';
import { OrderRoutingModule } from './order/order-routing.module';
import { AquaticCreaturesRoutingModule } from './aquatic-creatures/aquatic-creatures-routing.module';

@NgModule({
  declarations: [
    DashboardComponent,
    SidebarComponent,
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    EventRoutingModule,
    ProfileRoutingModule,
    OrderRoutingModule,
    AquaticCreaturesRoutingModule
  ]
})
export class DashboardModule { }
