import { Injectable } from '@angular/core';
import { Zahtev } from '../autorska/model/Zahtev';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as JsonToXML from "js2xmlparser";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ZigService {

  private baseUrl = 'http://localhost:8081/zig/';
  private requestOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
      'Accept': 'application/xml',
    }),
    responseType: 'text',
  }

  private blobResType: Object = {
    responseType: 'blob',
  }

  constructor(private http: HttpClient) { }

  sendNewRequest(zahtev: Zahtev) {
    const xmlPayload = JsonToXML.parse("ReguestZig", zahtev);
    return this.http.post<any>(`${this.baseUrl}new-request`, xmlPayload, this.requestOptions);
  }

  getAll(): any {
    return this.http.get<any>(`${this.baseUrl}all`, this.requestOptions);
  }

  sendResenje(resenje:any) {
    const xmlPayload = JsonToXML.parse("ResenjeDTO", resenje);
    return this.http.post<any>(`${this.baseUrl}new-resenje`, xmlPayload, this.requestOptions);
  }

  getPdf(format: string, brZahteva: string) {
    return this.http.get<any>(`${this.baseUrl}generate-pdf/${format}/${brZahteva}`, this.blobResType);
  }

}
