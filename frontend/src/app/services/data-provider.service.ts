import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { SmsData } from '@models/SmsData';
@Injectable({
  providedIn: 'root'
})
export class DataProviderService {

    constructor(private http: HttpClient) { }

      fetch() {
          return this.http.get<SmsData[]>('/assets/json/data.json');
      }
}
