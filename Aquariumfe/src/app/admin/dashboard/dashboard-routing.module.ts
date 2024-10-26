import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent,
    children: [
      {
        path: 'event',
        loadChildren: () => import('./event/event.module').then(m => m.EventModule)
      },
      {
        path: 'profile',
        loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule)
      },
      {
        path: 'aquatic-creatures',
        loadChildren: () => import('./aquatic-creatures/aquatic-creatures.module').then(m => m.AquaticCreaturesModule)
      },
      {
        path: 'type',
        loadChildren: () => import('./type/type.module').then(m => m.TypeModule)
      },
      {
        path: 'order',
        loadChildren: () => import('./order/order.module').then(m => m.OrderModule)
      },
      // {
      //   path: 'species',
        
      // },
     
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
