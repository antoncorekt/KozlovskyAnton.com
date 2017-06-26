import {  Injectable, EventEmitter } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';

@Injectable()
export class LanguageService {
    public langChanged: EventEmitter<String> = new EventEmitter<String>();

    constructor ( private localStorageService: LocalStorageService ) {
     
    }

    getLanguage(): String{
        let lang: String;
        lang = (String)(this.localStorageService.get("lang"));

        if (lang==="pl") return lang;
        if (lang==="en") return lang;
        if (lang==="ru") return lang;

        this.localStorageService.add("lang","en");
        return "en";
    }

    setLanguage(lang:String):void{
        
        if (lang==="pl" || lang==="en" || lang==="ru") 
        {
           this.localStorageService.add("lang",lang);
           this.langChanged.next(lang);
           return;
        }
        this.langChanged.next("en");
        this.localStorageService.add("lang","en");
    }

}