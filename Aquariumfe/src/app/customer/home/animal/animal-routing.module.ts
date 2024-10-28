import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnimalPageComponent } from './animal-page/animal-page.component';
import { AnimalDetailPageComponent } from './animal-detail-page/animal-detail-page.component';

const routes: Routes = [
  { path: 'list', component: AnimalPageComponent },
  { path: 'details/:id', component: AnimalDetailPageComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AnimalRoutingModule { }
