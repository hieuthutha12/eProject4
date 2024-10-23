import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAquaticCreaturesComponent } from './add-aquatic-creatures/add-aquatic-creatures.component';
import { UpdateAquaticCreaturesComponent } from './update-aquatic-creatures/update-aquatic-creatures.component';
import { ListAquaticCreaturesComponent } from './list-aquatic-creatures/list-aquatic-creatures.component';

const routes: Routes = [
  { path: 'add', component: AddAquaticCreaturesComponent },
  { path: 'update/:id', component: UpdateAquaticCreaturesComponent },
  { path: 'list', component: ListAquaticCreaturesComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AquaticCreaturesRoutingModule {}
