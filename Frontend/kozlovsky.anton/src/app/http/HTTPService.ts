import {  Injectable } from '@angular/core';
import {Http} from '@angular/http';

import 'rxjs/add/operator/map';
import * as Rx from "rxjs/Rx";


@Injectable()
export class myHTTPService {
  constructor(private http: Http) {}

  //configEndPoint: string = 'http://localhost:8080/api/test';

  getConfig(api: String) {

    return this.http
      .get('http://localhost:8080/api'+api)
      .map(res => res.json());
  }
} 