import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TypeRoutingModule } from './type-routing.module';
import { AddTypeComponent } from './add-type/add-type.component';
import { UpdateTypeComponent } from './update-type/update-type.component';
import { ListTypeComponent } from './list-type/list-type.component';
import { TypeFormComponent } from './type-form/type-form.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AddTypeComponent,
    UpdateTypeComponent,
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
