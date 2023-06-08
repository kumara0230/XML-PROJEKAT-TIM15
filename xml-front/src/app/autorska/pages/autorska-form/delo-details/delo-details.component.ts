import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/autorska/model/Zahtev';

@Component({
  selector: 'app-delo-details',
  templateUrl: './delo-details.component.html',
  styleUrls: ['./delo-details.component.scss']
})
export class DeloDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() { }

  ngOnInit(): void {

  }

  next() {
    this.form.get('delo')!.markAllAsTouched();
    this.form.get('delo')!.updateValueAndValidity();

    
    const formValues = this.form.get('delo')?.value;

    for (const key in formValues) {
      if (formValues[key] !== null) {
        if (!this.zahtev.delo) this.zahtev.delo = {}
        this.zahtev.delo[key] = formValues[key];
      }
    }
  }
}
