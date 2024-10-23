import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AquaticCreaturesRoutingModule } from './aquatic-creatures-routing.module';
import { AddAquaticCreaturesComponent } from './add-aquatic-creatures/add-aquatic-creatures.component';
import { UpdateAquaticCreaturesComponent } from './update-aquatic-creatures/update-aquatic-creatures.component';
import { ListAquaticCreaturesComponent } from './list-aquatic-creatures/list-aquatic-creatures.component';
import { AquaticCreaturesFormComponent } from './aquatic-creatures-form/aquatic-creatures-form.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AddAquaticCreaturesComponent,
    UpdateAquaticCreaturesComponent,
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
