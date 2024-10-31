import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home.component';
import { HomepageComponent } from './homepage/homepage.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { VisitComponent } from './visit/visit.component';
import { BuyTicketComponent } from './buy-ticket/buy-ticket.component';
import { AuthGuard } from '../service/auth.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: '',
        component: HomepageComponent,
      },
      {
        path: 'event',
        loadChildren: () => import('./event/event.module').then(m => m.EventModule)
      },
      {
        path: 'animal',
        loadChildren: () => import('./animal/animal.module').then(m => m.AnimalModule)
      },
      {
        path: 'buy-ticket',
        component: BuyTicketComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'feedback',
        component: FeedbackComponent,
      },
      {
        path: 'visit',
        component: VisitComponent,
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
