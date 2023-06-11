import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from '../../../model/Zahtev';
@Component({
  selector: 'app-punomocnik-zig-details',
  templateUrl: './punomocnik-zig-details.component.html',
  styleUrls: ['./punomocnik-zig-details.component.scss']
})
export class PunomocnikZigDetailsComponent implements OnInit{

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() {}

  ngOnInit(): void {
      
  }

  next() {
    this.form.get('punomocnik')!.markAllAsTouched();
    this.form.get('punomocnik')!.updateValueAndValidity();

    const punomocnikValues = this.form.get('punomocnik')?.value;
    const adresaFileds = ['ulica', 'broj', 'mesto', 'postanskiBroj'];
    this.zahtev.punomocnik = {
      adresa: {
        ulica: this.form.value['punomocnik']['ulica'],
        broj: Number(this.form.value['punomocnik']['broj']),
        mesto: this.form.value['punomocnik']['mesto'],
        postanskiBroj: Number(this.form.value['punomocnik']['postanskiBroj']),
      }
    };

    for (const key in punomocnikValues) {
      if (punomocnikValues[key] && !adresaFileds.includes(key)) {
        this.zahtev.punomocnik[key] = punomocnikValues[key];
      }
    }
    console.log(this.zahtev)
  }

}
