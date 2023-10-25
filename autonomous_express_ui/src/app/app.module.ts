import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './routes/landing-page/landing-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import {NgOptimizedImage} from "@angular/common";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatListModule} from "@angular/material/list";
import { MenuComponent } from './components/menu/menu.component';
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {LoginScreenComponent} from "./routes/login-screen/login-screen.component";
import { ManagementComponent } from './routes/management/management.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { ListComponent } from './components/list/list.component';
import {MatTableModule} from "@angular/material/table";
import { TrackerComponent } from './components/tracker/tracker.component';


@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    MenuComponent,
    LoginScreenComponent,
    ManagementComponent,
    SidebarComponent,
    ListComponent,
    TrackerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    NgOptimizedImage,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatInputModule,
    ReactiveFormsModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
