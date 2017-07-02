import {  Injectable } from '@angular/core';
import {Http} from '@angular/http';

import 'rxjs/add/operator/map';
import * as Rx from "rxjs/Rx";

import { LanguageService } from '../util/LanguageService';

@Injectable()
export class myHTTPService {
  constructor(private http: Http, private langService: LanguageService ) {}

  //configEndPoint: string = 'http://localhost:8080/api/test';

  req1: Object;

  getConfig(api: String, req:Object) {

   this.req1 = {
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
    } 
     

    return this.http
      .post('http://192.168.1.127:8080/root'+api,req)
      .map(res => res.json());
  }
} 