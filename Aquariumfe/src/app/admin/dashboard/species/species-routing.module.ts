import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListSpeciesComponent } from './list-species/list-species.component';
import { SpeciesFormComponent } from './species-form/species-form.component';

const routes: Routes = [
  { path: 'list', component: ListSpeciesComponent },
  { path: 'species/form', component: SpeciesFormComponent },
  { path: 'species/form/:id', component: SpeciesFormComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SpeciesRoutingModule { }
