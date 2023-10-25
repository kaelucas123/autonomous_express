import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginScreenComponent} from "./routes/login-screen/login-screen.component";
import {LandingPageComponent} from "./routes/landing-page/landing-page.component";
import {ManagementComponent} from "./routes/management/management.component";
import { TrackerComponent } from './components/tracker/tracker.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'home', component: LandingPageComponent},
  {path: 'management', component: ManagementComponent},
  {path: 'login', component: LoginScreenComponent},
  {path: 'tracker', component: TrackerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
