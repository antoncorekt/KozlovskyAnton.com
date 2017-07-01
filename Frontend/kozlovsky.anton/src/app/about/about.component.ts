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

    constructor(private myService: myHTTPService,
        private langService: LanguageService) {


    }

    ngOnChanges(changes: { [propKey: string]: SimpleChange }) {

    }


}