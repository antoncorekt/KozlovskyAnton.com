import { Component, Injectable, OnInit, Input, NgModule, OnChanges, SimpleChange } from '@angular/core';
import { myHTTPService } from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';
import { AppComponent } from '../app.component';


@Component({
    selector: 'app-main-component',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css'],
    providers: [myHTTPService, LanguageService]
})

@NgModule({
    bootstrap: [AppComponent, [LanguageService]]
})

@Injectable()
export class MainComponent implements OnChanges {

    @Input() lang: String;


    content: String;

    constructor(private myService: myHTTPService,
        private langService: LanguageService) {

        this.content = this.langService.getLanguage();

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


        let result = this.myService.getConfig('/public', req).subscribe(res => {

            this.content = JSON.stringify(res.data.lable).replace("\"",'').replace("\"",'');;
        });
    }




}
