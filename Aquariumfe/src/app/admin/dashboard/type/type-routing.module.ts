import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ListTypeComponent } from './list-type/list-type.component';

const routes: Routes = [
  { path: 'list', component: ListTypeComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TypeRoutingModule {}
