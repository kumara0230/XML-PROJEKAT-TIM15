import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/patenti/model/Zahtev';

@Component({
  selector: 'app-dostavljanje-patent-details',
  templateUrl: './dostavljanje-patent-details.component.html',
  styleUrls: ['./dostavljanje-patent-details.component.scss']
})
export class DostavljanjePatentDetailsComponent {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() {}

  ngOnInit(): void {}

  next() {
    this.form.get('dostavljanje')!.markAllAsTouched();
    this.form.get('dostavljanje')!.updateValueAndValidity();

    const dostavljanjeValues = this.form.get('dostavljanje')?.value;
    const adresaFileds = ['ulica', 'broj', 'mesto', 'postanskiBroj'];
    this.zahtev.dostavljanje = {
      adresa: {
        ulica: this.form.value['dostavljanje']['ulica'],
        broj: this.form.value['dostavljanje']['broj'],
        mesto: this.form.value['dostavljanje']['mesto'],
        postanskiBroj: this.form.value['dostavljanje']['postanskiBroj'],
      }
    };

    for (const key in dostavljanjeValues) {
      if (dostavljanjeValues[key] && !adresaFileds.includes(key)) {
        this.zahtev.dostavljanje[key] = dostavljanjeValues[key];
      }
    }
  }


}
