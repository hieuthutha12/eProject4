import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component'; 
import { SidebarComponent } from './sidebar/sidebar.component';
// import { EventModule } from './event/event.module';
import { ProfileModule } from './profile/profile.module';

@NgModule({
  declarations: [
    DashboardComponent,
    SidebarComponent,
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule ,
    // EventModule,
    ProfileModule
  ]
})
export class DashboardModule { }
