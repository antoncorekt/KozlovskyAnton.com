import { Component, Injectable } from '@angular/core';
import {myHTTPService} from './http/HTTPService';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ myHTTPService]
})




export class AppComponent {

  title:String;

  constructor(private myService: myHTTPService ){
      
  }



  result = this.myService.getConfig('/test').subscribe(res => {

    for(let i=0; i<res.length; i++){
      console.log(res[i]);
    }
    console.log(res);
     console.log(res[0].data);
    return this.title=JSON.stringify(res[0].data1);
  });


}
