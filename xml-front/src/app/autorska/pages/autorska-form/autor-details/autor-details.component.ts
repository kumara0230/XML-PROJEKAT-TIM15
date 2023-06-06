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

    if (this.isPodonosilacAutor()) return;

    this.zahtev.autor = {
      ulica: this.form.value['autor']['ulica'],
      broj: this.form.value['autor']['broj'],
      mesto: this.form.value['autor']['mesto'],
      postanskiBroj: this.form.value['autor']['postanskiBroj'],
      brojTelefona: this.form.value['autor']['brojTelefona'],
      email: this.form.value['autor']['email'],
      faks: this.form.value['autor']['faks'],
      ime: this.form.value['autor']['ime'],
      prezime: this.form.value['autor']['prezime'],
      drzavljanstvo: this.form.value['autor']['drzavljanstvo'],
      pseudonim: this.form.value['autor']['pseudonim'],
      godinaSmrti: this.form.value['autor']['godinaSmrti'],
      autorAnoniman: false
    }
  }
}
