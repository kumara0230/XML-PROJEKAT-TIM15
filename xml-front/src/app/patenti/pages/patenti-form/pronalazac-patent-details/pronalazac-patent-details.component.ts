import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/patenti/model/Zahtev';

@Component({
  selector: 'app-pronalazac-patent-details',
  templateUrl: './pronalazac-patent-details.component.html',
  styleUrls: ['./pronalazac-patent-details.component.scss']
})
export class PronalazacPatentDetailsComponent {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() { }

  ngOnInit(): void {}

  isPodonosilacPronalazac() {
    return this.form.value['podnosilac']['podnosilacPronalazac'];
  }

  next() {
    this.form.get('pronalazac')!.markAllAsTouched();
    this.form.get('pronalazac')!.updateValueAndValidity();

    if (this.isPodonosilacPronalazac()) {
      return;
    }

    const formValues = this.form.get('pronalazac')?.value;
    const adresaFileds = ['ulica', 'broj', 'mesto', 'postanskiBroj'];
    this.zahtev.pronalazac = {
      adresa: {
        ulica: this.form.value['pronalazac']['ulica'],
        broj: this.form.value['pronalazac']['broj'],
        mesto: this.form.value['pronalazac']['mesto'],
        postanskiBroj: this.form.value['pronalazac']['postanskiBroj'],
      }
    };

    for (const key in formValues) {
      if (formValues[key] && !adresaFileds.includes(key)) {
        this.zahtev.pronalazac[key] = formValues[key];
      }
    }
  }

}
