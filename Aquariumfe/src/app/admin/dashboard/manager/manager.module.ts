import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ManagerRoutingModule } from './manager-routing.module';
import { ListManagerComponent } from './list-manager/list-manager.component';
import { FormManagerComponent } from './form-manager/form-manager.component';


@NgModule({
  declarations: [
    ListManagerComponent,
    FormManagerComponent
  ],
  imports: [
    CommonModule,
    ManagerRoutingModule
  ]
})
export class ManagerModule { }
