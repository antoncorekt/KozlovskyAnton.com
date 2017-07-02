import { Component, Injectable, NgModule } from '@angular/core';
import {myHTTPService} from './http/HTTPService';
import { LanguageService } from './util/LanguageService';
import { MainComponent } from './main/main.component';
import { NavigationService } from './util/NavigationService';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ myHTTPService, LanguageService, MainComponent, NavigationService ]
})




export class AppComponent {
  
  title:String;
  page: String;

  constructor(private myService: myHTTPService,
              private langService: LanguageService,
              private mainPage: MainComponent ){
      this.page = "/main";
  }

  clickMessage = '';

  onClickMe(lang: String): void {
    this.clickMessage = 'You click -> ' +lang;
    this.langService.setLanguage(lang);
    

  }
}
