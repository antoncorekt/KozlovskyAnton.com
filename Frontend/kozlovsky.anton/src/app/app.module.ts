import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {Logger} from "angular2-logger/core";
import {RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { MainComponent} from './main/main.component'
import { HeaderComponent} from './header/header.component';
import { AboutComponent } from './about/about.component';
import { CvComponent } from './cv/cv.component';

import { LanguageService } from './util/LanguageService';
import { LocalStorageModule } from 'angular-2-local-storage';

const appRoutes: Routes = [
    
      {
        path: 'main',
        component: MainComponent
      },
      {
        path: 'about',
        component: AboutComponent
      }
];


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HeaderComponent,
    AboutComponent,
    CvComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    LocalStorageModule.withConfig({
            prefix: 'my-app',
            storageType: 'localStorage'
        })
  ],
  providers: [ Logger] ,
  bootstrap: [AppComponent] 
})
export class AppModule { }
