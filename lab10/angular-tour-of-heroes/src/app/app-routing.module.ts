import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { LoginComponent } from './login/login.component';
import { AuthenticatedGuard } from './authenticated.guard';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  //{ path: '', redirectTo: '/dashboard', pathMatch: 'full' },
 // { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: HeroDetailComponent,  canActivate: [AuthenticatedGuard] },
  { path: 'dashboard', component: DashboardComponent,  canActivate: [AuthenticatedGuard]},
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'heroes', component: HeroesComponent,  canActivate: [AuthenticatedGuard] }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}