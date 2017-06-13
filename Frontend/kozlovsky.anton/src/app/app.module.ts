import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {Logger} from "angular2-logger/core";
import {RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { MainComponent} from './main/main.component'

const appRoutes: Routes = [
    {path: '', component: MainComponent},
   
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
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ Logger] ,
  bootstrap: [AppComponent]
})
export class AppModule { }
