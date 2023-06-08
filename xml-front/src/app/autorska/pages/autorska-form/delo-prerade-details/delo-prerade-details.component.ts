import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Zahtev } from 'src/app/autorska/model/Zahtev';
import { AutorskaService } from 'src/app/services/autorska.service';

@Component({
  selector: 'app-delo-prerade-details',
  templateUrl: './delo-prerade-details.component.html',
  styleUrls: ['./delo-prerade-details.component.scss']
})
export class DeloPreradeDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor(private autorskaService: AutorskaService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {

  }


  isDeloPrerade() {
    return this.form.value['delo']['isDeloPrerade'];
  }

  isNextDisabled() {
    return this.isDeloPrerade() && !this.form.get('deloPrerade')?.valid;
  }


  next() { // finish
    this.form.get('deloPrerade')!.markAllAsTouched();
    this.form.get('deloPrerade')!.updateValueAndValidity();

    const formValues = this.form.get('deloPrerade')?.value;

    for (const key in formValues) {
      if (formValues[key] !== null) {
        if (!this.zahtev.delo!['deloPrerade']) this.zahtev.delo!['deloPrerade'] = {}
        this.zahtev.delo!['deloPrerade'][key] = formValues[key];
      }
    }

    this.autorskaService.sendNewRequest(this.zahtev).subscribe({
      next: () => {
        this.toastr.success('Request is successfully sent');
        this.router.navigate(['/autorska']);
      },
      error: (err) => {
        this.toastr.error(err.error);
      }
    });

  }
}
