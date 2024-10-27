import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { SpeciesComponent } from './species/species.component';
import { TypeComponent } from './type/type.component';
import { CustomerComponent } from './customer/customer.component';

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
        path: 'order',
        loadChildren: () => import('./order/order.module').then(m => m.OrderModule)
      },
      {
        path: 'manager',
        loadChildren: () => import('./manager/manager.module').then(m => m.ManagerModule)
      },
      {
        path: 'species',
        component:SpeciesComponent
      },
      {
        path: 'type',
        component:TypeComponent
      },
      {
        path: 'customer',
        component:CustomerComponent
      },
      
     
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
