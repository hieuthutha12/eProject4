import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GetProfileComponent } from './get-profile/get-profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';

const routes: Routes = [
  {
    path: '',
    component: GetProfileComponent
  },
  {
    path: 'update',
    component: UpdateProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
