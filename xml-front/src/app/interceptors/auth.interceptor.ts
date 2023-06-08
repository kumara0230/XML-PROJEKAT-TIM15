import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private router: Router, private authService: AuthService) { }

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {

    const authToken = localStorage.getItem('access_token');

    if (authToken && req.url.startsWith('http://localhost:')) {
      const cloned = req.clone({
        headers: req.headers.set('Authorization', '' + authToken),
      });

      return next.handle(cloned).pipe(
        tap(
          (err) => {
            if (err instanceof HttpErrorResponse) {
              if (err.status !== 401) {
                return;
              }
              this.authService.logout();
              this.router.navigate(['/login']);
            }
          }
        )
      );
    } else {
      return next.handle(req);
    }
  }
}