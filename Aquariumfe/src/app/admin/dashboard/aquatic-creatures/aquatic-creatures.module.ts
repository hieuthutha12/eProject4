import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AquaticCreaturesRoutingModule } from './aquatic-creatures-routing.module';
import { ListAquaticCreaturesComponent } from './list-aquatic-creatures/list-aquatic-creatures.component';
import { AquaticCreaturesFormComponent } from './aquatic-creatures-form/aquatic-creatures-form.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    ListAquaticCreaturesComponent,
    AquaticCreaturesFormComponent
  ],
  imports: [
    CommonModule,
    AquaticCreaturesRoutingModule,
    ReactiveFormsModule
  ]
})
export class AquaticCreaturesModule {}
