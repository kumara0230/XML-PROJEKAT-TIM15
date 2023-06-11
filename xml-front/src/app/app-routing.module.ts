import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/auth/login/login.component';
import { SignupComponent } from './pages/auth/signup/signup.component';
import { ChooseServiceComponent } from './pages/choose-service/choose-service.component';
import { AutorskaHomeComponent } from './autorska/pages/autorska-home/autorska-home.component';
import { AutorskaFormComponent } from './autorska/pages/autorska-form/autorska-form.component';
import { ReportComponent } from './autorska/pages/report/report.component';
import { ZigHomeComponent } from './autorska/zig/pages/zig-home/zig-home.component';
import { ZigFormComponent } from './autorska/zig/pages/zig-form/zig-form.component';

const routes: Routes = [
  {
    path: '', component: LoginComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'signup', component: SignupComponent
  },
  {
    path: 'choose-service', component: ChooseServiceComponent
  },
  {
    path: 'autorska', component: AutorskaHomeComponent
  },
  {
    path: 'autorska/new', component: AutorskaFormComponent
  },
  {
    path: 'autorska/reports', component: ReportComponent
  },
  {
    path: 'zig', component: ZigHomeComponent
  },
  {
    path: 'zig/new', component: ZigFormComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
