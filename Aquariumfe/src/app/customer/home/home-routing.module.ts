import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home.component';
import { HomepageComponent } from './homepage/homepage.component';

const routes: Routes = [
  {
     path: '',
     component: HomeComponent,
     children:[
       {
        path: '',
        component: HomepageComponent,
       },
       {
        path: 'event',
        loadChildren: () => import('./event/event.module').then(m => m.EventModule)
      },
     ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
