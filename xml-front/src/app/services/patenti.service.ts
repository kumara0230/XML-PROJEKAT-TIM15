import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as JsonToXML from 'js2xmlparser';
import { Zahtev } from '../patenti/model/Zahtev';

@Injectable({
  providedIn: 'root',
})
export class PatentiService {

  private baseUrl = 'http://localhost:8082/patenti/'; // izmeniti 
  private requestOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
      Accept: 'application/xml',
    }),
    responseType: 'text',
  };

  constructor(private http: HttpClient) {}


  sendNewRequest(zahtev: Zahtev) {
    console.log('pre parse');
    console.log(zahtev);
    console.log('-----------------------------------------------');
    const xmlPayload = JsonToXML.parse("RequestPatent", zahtev);
    console.log('-----------------------------------------------');
    console.log(xmlPayload);
    return this.http.post<any>(`${this.baseUrl}new-request`, xmlPayload, this.requestOptions);
  }

}
