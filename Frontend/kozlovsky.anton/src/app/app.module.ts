import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {Logger} from "angular2-logger/core";
import {RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { MainComponent} from './main/main.component'
import { LocalStorageModule } from 'angular-2-local-storage';

const appRoutes: Routes = [
    {path: '', component: MainComponent},
    {path: 'main', component: MainComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent
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
