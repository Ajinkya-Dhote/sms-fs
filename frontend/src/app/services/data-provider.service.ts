import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '@environments/environment';

import { SmsData } from '@models/SmsData';
@Injectable({
  providedIn: 'root'
})
export class DataProviderService {

    constructor(private http: HttpClient) { }

      fetch() {
          return this.http.get<SmsData[]>(environment.smsDataUrl);
      }
}
