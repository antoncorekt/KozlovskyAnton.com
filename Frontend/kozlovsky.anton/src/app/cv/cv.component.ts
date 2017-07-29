import { Component,Output,EventEmitter, Injectable, HostListener, OnInit, Input, NgModule, OnChanges, SimpleChange } from '@angular/core';
import { myHTTPService } from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';
import { NavigationService } from '../util/NavigationService';
import { AppComponent } from '../app.component';
import { HeaderComponent } from '../header/header.component';


@Component({
    selector: 'app-cv-component',
    templateUrl: './cv.component.html',
    styleUrls: ['./cv.component.css'],
    providers: [myHTTPService, LanguageService]
})



export class CvComponent implements OnChanges{

    @Input() lang: String;

    content:String;

    response:Object;

    listSkills: Array<String> = new Array<String>();

    constructor(
        private myService: myHTTPService,
        private langService: LanguageService,
        private navService: NavigationService) {

        this.content = "cv";

       

    }

    ngOnChanges(changes: { [propKey: string]: SimpleChange }) {

        let req = {
            "header": {
                "uuid": "id1",
                "language": this.langService.getLanguage(),
                "page": "about",
                "command": "get_cv_skills"
            },
            "data": {
                "query": "*"
            },
            "routedData": {
                "userID": "user1"
            }
        };

       
        let result = this.myService.getConfig('/public', req)
            .subscribe(res => {
                this.listSkills = new Array<String>();
                this.response = res.data.skills;

                this.content = res.data.skills.Java;
                
                let key: Object;
                for (key in res.data.skills) {
                    this.listSkills.push(key.toString());
                }


                for (key in res.data.skills) {
                    let k = document.getElementById(key.toString());
                     if(k===null) alert(key);
                    k.innerHTML = (res.data.skills[(Object)(key)]);
                   
                }

                console.log(this.listSkills);
                console.log(res.data.skills[(Object)(this.listSkills[0])]);
            });


        console.log("lalala-> " + this.langService.getLanguage());
    }

}