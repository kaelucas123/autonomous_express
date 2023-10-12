import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './routes/landing-page/landing-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import { LoginScreenComponent } from './routes/login-screen/login-screen.component';
import {NgOptimizedImage} from "@angular/common";


@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    LoginScreenComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatButtonModule,
        NgOptimizedImage
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
