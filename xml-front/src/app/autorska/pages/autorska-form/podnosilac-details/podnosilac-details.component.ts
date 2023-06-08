import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Podnosilac } from 'src/app/autorska/model/Podnosilac';
import { Zahtev } from 'src/app/autorska/model/Zahtev';

@Component({
  selector: 'app-podnosilac-details',
  templateUrl: './podnosilac-details.component.html',
  styleUrls: ['./podnosilac-details.component.scss']
})
export class PodnosilacDetailsComponent implements OnInit {

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
  }
  


}
