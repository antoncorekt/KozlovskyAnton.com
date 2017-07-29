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

  home:String;
  inputText:String;
  innerWidth: any;

  menuClicVar:boolean;

  constructor(private myService: myHTTPService,
              private langService: LanguageService,
              private navService: NavigationService
               ){
      this.page = "/main";
      this.page_router = "test";
      this.getMenu();
      this.setUiTextLang();
      this.innerWidth = (window.screen.width) + "px";
      this.menuClicVar = false;
  }


  menuClic():void{
    let menu = document.getElementById("menu");
    let mob = document.getElementById("mobile");

    if(this.menuClicVar){
      menu.className = "c-hamburger c-hamburger--rot";
      mob.className = "";
      this.menuClicVar = !this.menuClicVar;
    }
    else{
      menu.className += " btmenu-selected";
       mob.className = "mobile-header";
      this.menuClicVar = !this.menuClicVar;
    }
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

    this.setUiTextLang();
    
  }

  back():void{
    
     this.page = this.navService.back();
    
  }

  setUiTextLang():void{
    this.lang = this.langService.getLanguage();
    if(this.lang=='pl') {
      this.home = "Głowna";
      this.inputText = "Wpisz swój id: ";
    }
    if(this.lang=='en'){
      this.home = "Main";
      this.inputText = "Input your id: ";
    } 

    if(this.lang=='ru'){
       this.home = "Главная";
       this.inputText = "Введите свой id: ";
    }
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


  onClicMenuHeader(s:String):void{
    if (s === "about"){
            this.page='/about';

            this.navService.addPage('about');        
        }

        if (s === "cv"){
            this.page='/cv';

            this.navService.addPage('cv');        
        }
  }
}