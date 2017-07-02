import {  Injectable, EventEmitter } from '@angular/core';
import { myHTTPService } from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';

@Injectable()
export class NavigationService {

    private pages:Array<String> = new Array<String>();

    constructor(
        private myService: myHTTPService,
        private langService: LanguageService){
        
        this.pages.push('/main');
    }

    addPage(page:String):void{
        this.pages.push(page);
    }

    back():String{
        this.pages.pop();
        return this.pages[this.pages.length-1];
    }

    getAllPages():Array<String>{
        return this.pages;
    }

    getAllLocalizatePages():Array<String>{
        
        return null;
    }

    showBack():boolean{
        
        return (this.pages.length>1)?true:false;
    }

}