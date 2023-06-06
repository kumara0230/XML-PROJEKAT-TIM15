import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/autorska/model/Zahtev';

@Component({
  selector: 'app-punomocnik-details',
  templateUrl: './punomocnik-details.component.html',
  styleUrls: ['./punomocnik-details.component.scss']
})
export class PunomocnikDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() { }

  ngOnInit(): void {

  }

  noPunomocnik() {
    // TODO: ?
  }

  next() {
    this.form.get('punomocnik')!.markAllAsTouched();
    this.form.get('punomocnik')!.updateValueAndValidity();

    this.zahtev.punomocnik = {
      ulica: this.form.value['punomocnik']['ulica'],
      broj: this.form.value['punomocnik']['broj'],
      mesto: this.form.value['punomocnik']['mesto'],
      postanskiBroj: this.form.value['punomocnik']['postanskiBroj'],
      ime: this.form.value['punomocnik']['ime'],
      prezime: this.form.value['punomocnik']['prezime'],
    }
  }


}
