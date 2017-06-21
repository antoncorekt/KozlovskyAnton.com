import {  Injectable } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';

@Injectable()
export class LanguageService {

    center:String;


    constructor ( private localStorageService: LocalStorageService ) {
     
    }

    setCenter(s:String):void{
        this.center = s;
    }

    getCenter():String{
        return this.center;
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
           return;
        }
        this.localStorageService.add("lang","en");
    }

}