import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataProviderService {

    constructor(private http: HttpClient) { }

      fetch() {
          return this.http.get('/assets/json/data.json');
      }
}
