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


export class HeaderComponent  {
  @Input()
  lang:String = this.langService.getLanguage();

  @Input()
  page_router: String;

  
  page: String;

  constructor(private myService: myHTTPService,
              private langService: LanguageService
               ){
      this.page = "/main";
      this.page_router = "test";
  }

  onNotify(message:string):void {

  
     this.page = message;
  }

  onClickMe(lang: String): void {
   
    this.langService.setLanguage(lang);
    this.lang = lang;
    

    console.log("change to " + this.langService.getLanguage());  
            
  }

}