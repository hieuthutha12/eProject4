import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListAquaticCreaturesComponent } from './list-aquatic-creatures/list-aquatic-creatures.component';

const routes: Routes = [
  { path: 'list', component: ListAquaticCreaturesComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AquaticCreaturesRoutingModule {}
