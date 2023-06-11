import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from '../../../model/Zahtev';
import { MatRadioChange } from '@angular/material/radio';

@Component({
  selector: 'app-vrsta-ziga-details',
  templateUrl: './vrsta-ziga-details.component.html',
  styleUrls: ['./vrsta-ziga-details.component.scss']
})
export class VrstaZigaDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;
  vrstaZigaChoseN: string = "";

  constructor() {}

  ngOnInit(): void {
      
  }

  optionChangedKind($event: MatRadioChange) {
    if ($event.value === '1') {
      this.vrstaZigaChoseN = "1"
    } else if ($event.value === '2') {
      this.vrstaZigaChoseN = "2"
    } else if ($event.value === '3') {
      this.vrstaZigaChoseN = "3"
    } else {
      this.vrstaZigaChoseN = "0"
    }
}

  next() {
    // this.form.get('vrsta_ziga')!.markAllAsTouched();
    // this.form.get('vrsta_ziga')!.updateValueAndValidity();

    const podnosilacValues = this.form.get('vrsta_ziga')?.value;
    this.zahtev.vrsta_ziga = this.vrstaZigaChoseN;

    console.log(this.zahtev);
  }



}
