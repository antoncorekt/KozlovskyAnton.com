import { Component, Injectable, OnInit, Input, NgModule, OnChanges, SimpleChange } from '@angular/core';
import { myHTTPService } from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';
import { AppComponent } from '../app.component';


@Component({
    selector: 'app-about-component',
    templateUrl: './about.component.html',
    styleUrls: ['./about.component.css'],
    providers: [myHTTPService, LanguageService]
})

export class AboutComponent implements OnChanges {
    @Input() lang: String;

    
    @Input() page: String;


    content:String;
    menuData:Object;

    constructor(private myService: myHTTPService,
        private langService: LanguageService) {
        
        this.content = "Hello my name is Anton. And I am programmer."

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

               
            });

        let result1 = this.myService.getConfig('/public', reqMenu)
            .subscribe(res => {
                this.menuData = res.data.data;
            });

        console.log("lalala-> " + this.langService.getLanguage());
    }


}