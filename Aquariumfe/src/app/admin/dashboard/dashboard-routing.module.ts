import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { SpeciesComponent } from './species/species.component';
import { TypeComponent } from './type/type.component';
import { CustomerComponent } from './customer/customer.component';
import { AuthGuard } from '../services/auth.guard';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent,
    children: [
      {
        path: 'event',
        loadChildren: () => import('./event/event.module').then(m => m.EventModule),
        canActivate: [AuthGuard] 
      },
      {
        path: 'profile',
        loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule),
        canActivate: [AuthGuard] 
      },
      {
        path: 'aquatic-creatures',
        loadChildren: () => import('./aquatic-creatures/aquatic-creatures.module').then(m => m.AquaticCreaturesModule),
        canActivate: [AuthGuard] 
      },
      {
        path: 'order',
        loadChildren: () => import('./order/order.module').then(m => m.OrderModule),
        canActivate: [AuthGuard] 
      },
      {
        path: 'manager',
        loadChildren: () => import('./manager/manager.module').then(m => m.ManagerModule),
        canActivate: [AuthGuard] 
      },
      {
        path: 'species',
        component:SpeciesComponent,
        canActivate: [AuthGuard] 
      },
      {
        path: 'type',
        component:TypeComponent,
        canActivate: [AuthGuard] 
      },
      {
        path: 'customer',
        component:CustomerComponent,
        canActivate: [AuthGuard] 
      },
      {
        path: '',
        component:HomeComponent,
        canActivate: [AuthGuard] 
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
