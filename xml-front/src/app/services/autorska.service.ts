import { Injectable } from '@angular/core';
import { Zahtev } from '../autorska/model/Zahtev';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as JsonToXML from "js2xmlparser";

@Injectable({
  providedIn: 'root'
})
export class AutorskaService {

  private baseUrl = 'http://localhost:8081/autorska/';
  private requestOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
      'Accept': 'application/xml',
    }),
    responseType: 'text',
  }

  constructor(private http: HttpClient) { }

  sendNewRequest(zahtev: Zahtev) {
    const xmlPayload = JsonToXML.parse("RequestAutorskoDelo", zahtev);
    console.log(xmlPayload);
    return this.http.post<any>(`${this.baseUrl}register`, xmlPayload, this.requestOptions);
  }
}
