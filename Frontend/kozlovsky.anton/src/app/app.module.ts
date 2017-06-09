import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {Logger} from "angular2-logger/core";

import { AppComponent } from './app.component';
import { MainComponent} from './main/main.component'

@NgModule({
  declarations: [
    AppComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [ Logger] ,
  bootstrap: [AppComponent]
})
export class AppModule { }
