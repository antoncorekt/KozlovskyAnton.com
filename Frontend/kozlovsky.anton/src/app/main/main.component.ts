import { Component, Injectable, OnInit } from '@angular/core';
import { myHTTPService } from '../http/HTTPService';
import { LanguageService } from '../util/LanguageService';


@Component({
  selector: 'app-main-component',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
  providers: [ myHTTPService, LanguageService]
})


export class MainComponent implements OnInit {
  
  kek="xsaxa";
  content:String;
  lol: String;
  req: Object = {
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
    } ;

  constructor(private myService: myHTTPService,
              private langService: LanguageService ){
      this.lol = "BLYYAaa";
     // langService.setCenter(this.lol);
      //this.update("lol");

  }


  lolol():void{
     this.lol = this.langService.getLanguage();
      console.log("this.lol = " + this.lol);
  }

 ngOnInit(): void {
      
    this.content = this.langService.getLanguage();

    console.log("-> content" + this.content);

   /* this.lol = this.langService.getLanguage();
    console.log("this.lol = " + this.lol);
    let req  = {
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
    } ;

    
    let result = this.myService.getConfig('/public', req).subscribe(res => {
         
    return this.content=JSON.stringify(res.data.lable);

       // return true;
     );*/
  }

}
