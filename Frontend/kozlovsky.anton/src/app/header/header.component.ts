import { Component, Injectable, NgModule, Input } from '@angular/core';
import {myHTTPService} from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';
import { MainComponent } from '../main/main.component';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  providers: [ myHTTPService, LanguageService, MainComponent]
})

@NgModule({
  declarations: [
    MainComponent,
  ],
  providers: [
    MainComponent
  ],
   bootstrap: [AppComponent, [LanguageService]]
})


export class HeaderComponent {
  @Input()
  lang:String = this.langService.getLanguage();

  page: String;

  constructor(private myService: myHTTPService,
              private langService: LanguageService,
              private mainComponent: MainComponent ){
      this.page = "/main";
  }



  onClickMe(lang: String): void {
   
    this.langService.setLanguage(lang);
    this.lang = lang;
  }
}