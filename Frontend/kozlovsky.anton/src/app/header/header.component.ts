import { Component, Injectable, NgModule, Input, SimpleChange, OnChanges } from '@angular/core';
import {myHTTPService} from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';
import { MainComponent } from '../main/main.component';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  providers: [ myHTTPService, LanguageService]
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


export class HeaderComponent  implements OnChanges {
  @Input()
  lang:String = this.langService.getLanguage();

  @Input()
  test: String;

  
  page: String;

  constructor(private myService: myHTTPService,
              private langService: LanguageService
               ){
      this.page = "/main";
      this.test = "test";
  }

  lollol():void {
    this.page = "/about";
  }

  onClickMe(lang: String): void {
   
    this.langService.setLanguage(lang);
    this.lang = lang;
    
    this.test = "header change to " + lang; 
    console.log("change to " + this.langService.getLanguage());  
            
  }

   ngOnChanges(changes: { [propKey: string]: SimpleChange }) {

    this.test = "yeeeea"!
   }
}