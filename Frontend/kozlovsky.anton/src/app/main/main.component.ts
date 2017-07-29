import { Component,Output,EventEmitter, Injectable, HostListener, OnInit, Input, NgModule, OnChanges, SimpleChange } from '@angular/core';
import { myHTTPService } from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';
import { NavigationService } from '../util/NavigationService';
import { AppComponent } from '../app.component';
import { HeaderComponent } from '../header/header.component';


@Component({
    selector: 'app-main-component',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css'],
    providers: [myHTTPService, LanguageService]
})



export class MainComponent implements OnChanges {

    @Input() lang: String;
  
    @Output() page_router: EventEmitter<string> = new EventEmitter<string>();

    content: String;
    menuData: Object;

    constructor(
        private myService: myHTTPService,
        private langService: LanguageService,
        private navService: NavigationService) {

        this.content = "Waiting.. Site try connect to server..";

    }

    @HostListener('window:resize', ['$event'])
        onResize(event) {
        
        console.log(event.target.innerWidth);
    }

    ngOnChanges(changes: { [propKey: string]: SimpleChange }) {

        let req = {
            "header": {
                "uuid": "id1",
                "language": this.langService.getLanguage(),
                "page": "main",
                "command": "center"
            },
            "data": null,
            "routedData": {
                "userID": "user1"
            }
        };

        let reqMenu = {
            "header": {
                "uuid": "sdsd",
                "language": this.langService.getLanguage(),
                "page": "main",
                "command": "menu"
            },
            "data": null,
            "routedData": {
                "userID": "user1"
            }
        };

        let result = this.myService.getConfig('/public', req)
            .subscribe(res => {

                this.content = JSON.stringify(res.data.lable)
                                                .replace("\"", '')
                                                .replace("\"", '');
                console.log(this.content);
            });

        let result1 = this.myService.getConfig('/public', reqMenu)
            .subscribe(res => {
                this.menuData = res.data.data;
            });

        console.log("lalala-> " + this.langService.getLanguage());
    }


    onClicMenu(s:String):void{
      
        if (s === "about"){
            this.page_router.emit('/about');

            this.navService.addPage('about');        
        }

        if (s === "cv"){
            this.page_router.emit('/cv');

            this.navService.addPage('cv');        
        }
        
    }



}
