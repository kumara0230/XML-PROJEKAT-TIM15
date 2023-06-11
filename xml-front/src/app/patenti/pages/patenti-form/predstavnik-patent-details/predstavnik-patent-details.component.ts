import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/patenti/model/Zahtev';

@Component({
  selector: 'app-predstavnik-patent-details',
  templateUrl: './predstavnik-patent-details.component.html',
  styleUrls: ['./predstavnik-patent-details.component.scss']
})
export class PredstavnikPatentDetailsComponent {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() {}

  ngOnInit(): void {}

  next() {
    this.form.get('predstavnik')!.markAllAsTouched();
    this.form.get('predstavnik')!.updateValueAndValidity();

    const predstavnikValues = this.form.get('predstavnik')?.value;
    const adresaFileds = ['ulica', 'broj', 'mesto', 'postanskiBroj'];
    this.zahtev.predstavnik = {
      adresa: {
        ulica: this.form.value['predstavnik']['ulica'],
        broj: this.form.value['predstavnik']['broj'],
        mesto: this.form.value['predstavnik']['mesto'],
        postanskiBroj: this.form.value['predstavnik']['postanskiBroj'],
      }
    };

    for (const key in predstavnikValues) {
      if ((predstavnikValues[key] !== null) && !adresaFileds.includes(key)) {
        this.zahtev.predstavnik[key] = predstavnikValues[key];
      }
    }
  }

}
