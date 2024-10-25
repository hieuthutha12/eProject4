import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SpeciesRoutingModule } from './species-routing.module';
import { ListSpeciesComponent } from './list-species/list-species.component';
import { SpeciesFormComponent } from './species-form/species-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ListSpeciesComponent,
    SpeciesFormComponent
  ],
  imports: [
    CommonModule,
    SpeciesRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class SpeciesModule { }
