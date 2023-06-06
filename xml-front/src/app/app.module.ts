import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/auth/login/login.component';
import { LoginFormComponent } from './components/auth/login-form/login-form.component';
import { SignupFormComponent } from './components/auth/signup-form/signup-form.component';
import { SignupComponent } from './pages/auth/signup/signup.component';
import { ToastrModule } from 'ngx-toastr';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { ChooseServiceComponent } from './pages/choose-service/choose-service.component';
import { AutorskaHomeComponent } from './autorska/pages/autorska-home/autorska-home.component';
import { AutorskaFormComponent } from './autorska/pages/autorska-form/autorska-form.component';
import { PodnosilacDetailsComponent } from './autorska/pages/autorska-form/podnosilac-details/podnosilac-details.component';
import { AutorDetailsComponent } from './autorska/pages/autorska-form/autor-details/autor-details.component';
import { PunomocnikDetailsComponent } from './autorska/pages/autorska-form/punomocnik-details/punomocnik-details.component';
import { DeloDetailsComponent } from './autorska/pages/autorska-form/delo-details/delo-details.component';
import { DeloPreradeDetailsComponent } from './autorska/pages/autorska-form/delo-prerade-details/delo-prerade-details.component';

import {MatToolbarModule} from '@angular/material/toolbar';

import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatStepperModule} from '@angular/material/stepper';
import {MatInputModule} from '@angular/material/input';
import { NavbarComponent } from './components/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LoginFormComponent,
    SignupFormComponent,
    SignupComponent,
    ChooseServiceComponent,
    AutorskaHomeComponent,
    AutorskaFormComponent,
    PodnosilacDetailsComponent,
    AutorDetailsComponent,
    PunomocnikDetailsComponent,
    DeloDetailsComponent,
    DeloPreradeDetailsComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatStepperModule,
    MatInputModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
