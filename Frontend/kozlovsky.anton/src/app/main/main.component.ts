import { Component, Injectable } from '@angular/core';
import {myHTTPService} from '../http/HTTPService';


@Component({
  selector: 'lol',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
  providers: [ myHTTPService]
})

 
export class MainComponent {

  content:String;

  constructor(private myService: myHTTPService ){
      
  }

  result = this.myService.getConfig('/test').subscribe(res => {

    for(let i=0; i<res.length; i++){
      console.log(res[i]);
    }
    console.log(res);
    return this.content=JSON.stringify(res[1].data);
  });


}
