import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import DecodeJwt from 'src/app/helpers/decodeJwt';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  user: any = {}

  constructor (private router: Router) {}

  ngOnInit(): void {
    this.user = DecodeJwt.getUserFromAuthToken();
  }

  logout() {
    localStorage.removeItem('access_token');
    this.router.navigate(['/login'])
  }
}
