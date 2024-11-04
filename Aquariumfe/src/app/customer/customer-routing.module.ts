import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LoginGuard } from './service/login.guard';

const routes: Routes = [
  { path: 'login', component: LoginComponent,canActivate: [LoginGuard] },
  { path: 'register', component: RegisterComponent,canActivate: [LoginGuard] },
  {
    path: '',
    loadChildren: () => import('./home/home.module').then(m => m.HomeModule),
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
