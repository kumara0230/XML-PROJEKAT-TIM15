import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { LoginResponse } from '../models/LoginResponse';
import * as JsonToXML from "js2xmlparser";

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  private baseUrl = 'http://localhost:8089/auth/';
  private requestOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type': 'application/xml',
      'Accept': 'application/xml',
    }),
    responseType: 'text',
  }

  constructor(private http: HttpClient) { }

  whoAmI(): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}whoami`);
  }

  signUp(userObj: any) {
    const xmlPayload = JsonToXML.parse("korisnikDTO", userObj);
    return this.http.post<any>(`${this.baseUrl}register`, xmlPayload, this.requestOptions);
  }

  login(loginObj: any) {
    const xmlPayload = JsonToXML.parse("loginRequest", loginObj);
    return this.http.post<any>(`${this.baseUrl}login`, xmlPayload, this.requestOptions);
  }

  logout() {
    sessionStorage.removeItem('access_token');
  }

  isLoggedIn() {
    if (!sessionStorage.getItem('access_token')) {
      return false;
    }
    return true;
  }
}
