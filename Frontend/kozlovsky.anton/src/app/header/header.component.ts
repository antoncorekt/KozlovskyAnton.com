import { Component, Injectable, NgModule, Input, SimpleChange, OnChanges } from '@angular/core';
import { myHTTPService} from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';
import { MainComponent } from '../main/main.component';
import { AppComponent } from '../app.component';
import { NavigationService } from '../util/NavigationService';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})


export class HeaderComponent  {
  @Input()
  lang:String = this.langService.getLanguage();

  @Input()
  page_router: String;

  page: String;

  menuData: Object;

  constructor(private myService: myHTTPService,
              private langService: LanguageService,
              private navService: NavigationService
               ){
      this.page = "/main";
      this.page_router = "test";
      this.getMenu();
  }

  onNotify(message:string):void {

  
     this.page = message;
  }

  onClickMe(lang: String): void {
   
    this.langService.setLanguage(lang);
    this.lang = lang;
    
    console.log("change to " + this.langService.getLanguage()); 

    if(this.page != '/main'){
      this.getMenu();
    }  
  }

  back():void{
    
     this.page = this.navService.back();
    
  }


  getMenu(): void {
    let reqMenu = {
            "header": {
                "uuid": "sdcsd",
                "language": this.langService.getLanguage(),
                "page": "main",
                "command": "menu"
            },
            "data": null,
            "routedData": {
                "userID": "user1"
            }
        };

    let result1 = this.myService.getConfig('/public', reqMenu)
            .subscribe(res => {
                this.menuData = res.data.data;
            });
  }

}