import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TypeRoutingModule } from './type-routing.module';
import { ListTypeComponent } from './list-type/list-type.component';
import { TypeFormComponent } from './type-form/type-form.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ListTypeComponent,
    TypeFormComponent
  ],
  imports: [
    CommonModule,
    TypeRoutingModule,
    ReactiveFormsModule
  ]
})
export class TypeModule { }
