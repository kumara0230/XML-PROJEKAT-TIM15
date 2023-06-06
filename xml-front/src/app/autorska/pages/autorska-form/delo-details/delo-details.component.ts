import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from 'src/app/autorska/model/Zahtev';

@Component({
  selector: 'app-delo-details',
  templateUrl: './delo-details.component.html',
  styleUrls: ['./delo-details.component.scss']
})
export class DeloDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;

  constructor() { }

  ngOnInit(): void {

  }

  next() {
    this.form.get('delo')!.markAllAsTouched();
    this.form.get('delo')!.updateValueAndValidity();

    this.zahtev.delo = {
      naslov: this.form.value['delo']['naslov'],
      vrsta: this.form.value['delo']['vrsta'],
      formaZapisa: this.form.value['delo']['formaZapisa'],
      alternativniNaziv: this.form.value['delo']['alternativniNaziv'],
      deloStvorenoURadnomOdnosu: this.form.value['delo']['deloStvorenoURadnomOdnosu'],
      nacinKoriscenjaDela: this.form.value['delo']['nacinKoriscenjaDela'],
    }
  }
}
