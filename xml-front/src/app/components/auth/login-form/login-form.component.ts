import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpErrorResponse } from '@angular/common/http';
import ValidateForm from 'src/app/helpers/validateform';
import { AuthService } from 'src/app/services/auth.service';
import DecodeJwt from 'src/app/helpers/decodeJwt';
import { LoginResponse } from 'src/app/models/LoginResponse';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {
  type = 'password';
  isText = false;
  eyeIcon = 'fa-eye-slash';
  loginForm!: FormGroup;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private auth: AuthService,
    private toastr: ToastrService
  ) { }

  hideShowPass() {
    this.isText = !this.isText;
    this.isText ? (this.eyeIcon = 'fa-eye') : (this.eyeIcon = 'fa-eye-slash');
    this.isText ? (this.type = 'text') : (this.type = 'password');
  }

  ngOnInit(): void {
    localStorage.removeItem('access_token');

    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
  }

  onLogin() {
    if (this.loginForm.valid) {
      this.auth.login(this.loginForm.value).subscribe({
        next: (res) => {
          this.successLogin(res);
        },
        error: (err) => {
          this.loginError(err);
        },
      });
    } else {
      ValidateForm.validateAllFormFields(this.loginForm);
    }
  }

  successLogin(res: LoginResponse) {
    sessionStorage.setItem('access_token', res.accessToken);
    this.router.navigate(['/choose-service']);
  }

  loginError(err: HttpErrorResponse) {
    if (err.status === 409)
      this.toastr.error(
        'Please login with your email and password.\nOnly clients can sign-in with Facebook or Google',
        'Login Error'
      );
    else if (err.status === 401)
      this.toastr.error('Wrong email or password', 'Login Error');
    else if (err.status === 403)
      this.toastr.error('Please confirm your email address', 'Login Error');
    else this.toastr.error('An unexpected error occurred', 'Login Error');
  }
}
