import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from '../../../model/Zahtev';

@Component({
  selector: 'app-podnosilac-zig-details',
  templateUrl: './podnosilac-zig-details.component.html',
  styleUrls: ['./podnosilac-zig-details.component.scss']
})
export class PodnosilacZigDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() {}

  ngOnInit(): void {
      
  }

  next() {
    this.form.get('podnosilac')!.markAllAsTouched();
    this.form.get('podnosilac')!.updateValueAndValidity();

    const podnosilacValues = this.form.get('podnosilac')?.value;
    const adresaFileds = ['ulica', 'broj', 'mesto', 'postanskiBroj'];
    this.zahtev.podnosilac = {
      adresa: {
        ulica: this.form.value['podnosilac']['ulica'],
        broj: this.form.value['podnosilac']['broj'],
        mesto: this.form.value['podnosilac']['mesto'],
        postanskiBroj: this.form.value['podnosilac']['postanskiBroj'],
      }
    };

    for (const key in podnosilacValues) {
      if (podnosilacValues[key] && !adresaFileds.includes(key)) {
        this.zahtev.podnosilac[key] = podnosilacValues[key];
      }
    }
    console.log(this.zahtev);
  }

}
