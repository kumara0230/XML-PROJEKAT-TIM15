import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/autorska/model/Zahtev';

@Component({
  selector: 'app-autor-details',
  templateUrl: './autor-details.component.html',
  styleUrls: ['./autor-details.component.scss']
})
export class AutorDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() { }

  ngOnInit(): void {

  }

  isPodonosilacAutor() {
    return this.form.value['podnosilac']['podnosilacAutor'];
  }

  autorAnoniman() {
    this.form.value['autor']['autorAnoniman'] = true;
    this.form.get('autor')!.markAllAsTouched();
    this.form.get('autor')!.updateValueAndValidity();
    this.zahtev.autor = {
      autorAnoniman: true
    }
  }

  next() {
    this.form.get('autor')!.markAllAsTouched();
    this.form.get('autor')!.updateValueAndValidity();

    if (this.isPodonosilacAutor()) {
      if (this.form.value['autor']['pseudonim'] != null) {
        this.zahtev.autor = {
          pseudonim: this.form.value['autor']['pseudonim']
        }
      }
      return;
    }

    const formValues = this.form.get('autor')?.value;
    const adresaFileds = ['ulica', 'broj', 'mesto', 'postanskiBroj'];
    this.zahtev.autor = {
      adresa: {
        ulica: this.form.value['autor']['ulica'],
        broj: this.form.value['autor']['broj'],
        mesto: this.form.value['autor']['mesto'],
        postanskiBroj: this.form.value['autor']['postanskiBroj'],
      }
    };

    for (const key in formValues) {
      if (formValues[key] && !adresaFileds.includes(key)) {
        this.zahtev.autor[key] = formValues[key];
      }
    }
  }
}
