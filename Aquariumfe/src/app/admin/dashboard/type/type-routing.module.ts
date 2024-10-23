import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTypeComponent } from './add-type/add-type.component';
import { UpdateTypeComponent } from './update-type/update-type.component';
import { ListTypeComponent } from './list-type/list-type.component';

const routes: Routes = [
  { path: 'add', component: AddTypeComponent },
  { path: 'update/:id', component: UpdateTypeComponent },
  { path: 'list', component: ListTypeComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TypeRoutingModule {}
