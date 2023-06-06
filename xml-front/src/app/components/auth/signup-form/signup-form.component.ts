import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import ValidateForm, { passwordMatch } from 'src/app/helpers/validateform';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.scss']
})
export class SignupFormComponent implements OnInit {

  type = 'password';
  isText = false;
  eyeIcon = 'fa-eye-slash';
  signupForm!: FormGroup;
  disableSubmit = false;
  confirmationStatus!: boolean;

  constructor(
    private fb: FormBuilder,
    private auth: AuthService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    localStorage.removeItem('access_token');

    this.signupForm = this.fb.group({
      firstName: [
        '',
        [
          Validators.minLength(2),
          Validators.required,
          Validators.maxLength(32),
        ],
      ],
      lastName: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(32),
        ],
      ],
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(8),
          Validators.maxLength(32),
        ],
      ],
      repPassword: ['', Validators.required],
      isSluzbenik: [false],
    });

    this.signupForm.addValidators(
      passwordMatch(
        this.signupForm.controls['password'],
        this.signupForm.controls['repPassword']
      )
    );
  }

  hideShowPass() {
    this.isText = !this.isText;
    this.isText ? (this.eyeIcon = 'fa-eye') : (this.eyeIcon = 'fa-eye-slash');
    this.isText ? (this.type = 'text') : (this.type = 'password');
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  onSingup() {
    if (this.signupForm.valid) {
      this.disableSubmit = true;
      const payload = {
        email: this.signupForm.value['email'],
        password: this.signupForm.value['password'],
        name: this.signupForm.value['firstName'],
        lastName: this.signupForm.value['lastName'],
        sluzbenik: this.signupForm.value['isSluzbenik'],
      }

      this.auth.signUp(payload).subscribe({
        next: (res) => {
          this.toastr
            .success(
              'Successfully registered!'
            );
          this.signupForm.reset();
          this.router.navigate(['/login']);
        },
        error: (err) => {
          this.confirmationStatus = false;
          this.disableSubmit = false;
          if (err.status === 400)
            this.toastr.error(
              'An account is already registered with your email.',
              'Registration Error',
            );
          else
            this.toastr.error(
              'An unexpected error occurred',
              'Registration Error'
            );
        },
      });
    } else {
      ValidateForm.validateAllFormFields(this.signupForm);
    }
  }

}
