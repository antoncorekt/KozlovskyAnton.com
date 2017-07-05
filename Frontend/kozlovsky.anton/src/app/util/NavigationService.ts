import {  Injectable, EventEmitter } from '@angular/core';
import { myHTTPService } from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';

@Injectable()
export class NavigationService {

    private history:Array<String> = new Array<String>();

    private pages:Array<String> = new Array<String>();

    private localPages:Array<String> = new Array<String>();

    constructor(
        private myService: myHTTPService,
        private langService: LanguageService){
        
        this.pages.push('/main');
        this.history.push('/main');
    }

    addPage(page:String):void{
        this.history.push(page);
    }

    back():String{
        this.history.pop();
        return this.history[this.pages.length-1];
    }

    getAllPages():Array<String>{
        return this.pages;
    }

    getAllLocalizatePages():Array<String>{
        
        return null;
    }



    showBack():boolean{
        
        return (this.history.length>1)?true:false;
    }

}