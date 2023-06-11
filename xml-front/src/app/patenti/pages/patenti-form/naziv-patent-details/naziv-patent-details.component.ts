import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/patenti/model/Zahtev';

@Component({
  selector: 'app-naziv-patent-details',
  templateUrl: './naziv-patent-details.component.html',
  styleUrls: ['./naziv-patent-details.component.scss']
})
export class NazivPatentDetailsComponent {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() {}
  ngOnInit(): void {}

  next() {
    this.form.get('nazivPronalaska')!.markAllAsTouched();
    this.form.get('nazivPronalaska')!.updateValueAndValidity();

    const nazivValues = this.form.get('nazivPronalaska')?.value;
    const adresaFileds = ['ulica', 'broj', 'mesto', 'postanskiBroj'];
    this.zahtev.nazivPronalaska = {};

    for (const key in nazivValues) {
      if (nazivValues[key] && !adresaFileds.includes(key)) {
        this.zahtev.nazivPronalaska[key] = nazivValues[key];
      }
    }
    
  }

}
