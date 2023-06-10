import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/auth/login/login.component';
import { LoginFormComponent } from './components/auth/login-form/login-form.component';
import { SignupFormComponent } from './components/auth/signup-form/signup-form.component';
import { SignupComponent } from './pages/auth/signup/signup.component';
import { ToastrModule } from 'ngx-toastr';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { MatDialogModule } from '@angular/material/dialog';
import { ResenjeModalComponent } from './autorska/pages/resenje-modal/resenje-modal.component';
import { PatentiFormComponent } from './patenti/pages/patenti-form/patenti-form.component';
import { PodnosilacPatentDetailsComponent } from './patenti/pages/patenti-form/podnosilac-patent-details/podnosilac-patent-details.component';
import { NazivPatentDetailsComponent } from './patenti/pages/patenti-form/naziv-patent-details/naziv-patent-details.component';
import { PronalazacPatentDetailsComponent } from './patenti/pages/patenti-form/pronalazac-patent-details/pronalazac-patent-details.component';
import { PredstavnikPatentDetailsComponent } from './patenti/pages/patenti-form/predstavnik-patent-details/predstavnik-patent-details.component';
import { DostavljanjePatentDetailsComponent } from './patenti/pages/patenti-form/dostavljanje-patent-details/dostavljanje-patent-details.component';
import { RanijePrijavePatentDetailsComponent } from './patenti/pages/patenti-form/ranije-prijave-patent-details/ranije-prijave-patent-details.component';

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
    NavbarComponent,
    ResenjeModalComponent,
    PatentiFormComponent,
    PodnosilacPatentDetailsComponent,
    NazivPatentDetailsComponent,
    PronalazacPatentDetailsComponent,
    PredstavnikPatentDetailsComponent,
    DostavljanjePatentDetailsComponent,
    RanijePrijavePatentDetailsComponent
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
    MatDialogModule,
    FormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
