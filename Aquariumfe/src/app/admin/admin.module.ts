import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardModule } from './dashboard/dashboard.module';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    AdminComponent,
    LoginComponent,
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    DashboardModule,
    RouterModule     
  ]
})
export class AdminModule { }

