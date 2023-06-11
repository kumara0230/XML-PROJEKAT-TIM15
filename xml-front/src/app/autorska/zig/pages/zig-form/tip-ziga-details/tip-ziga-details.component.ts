import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Zahtev } from '../../../model/Zahtev';
import { MatRadioChange } from '@angular/material/radio';

@Component({
  selector: 'app-tip-ziga-details',
  templateUrl: './tip-ziga-details.component.html',
  styleUrls: ['./tip-ziga-details.component.scss']
})
export class TipZigaDetailsComponent implements OnInit {

  @Input() form!: FormGroup;
  @Input() zahtev!: Zahtev;
  isHiddenOtherKind: boolean = true;
  isVerbalniZnak: boolean = true;
  isStraniJezik: boolean = true;
  izabranaVrednost: string = "";
  transliteracija: string = "";
  prevod: string = "";
  druga_vrsta_znaka: string = "";

  constructor() {}

  ngOnInit(): void {
      
  }
  optionChangedKind($event: MatRadioChange) {
    if ($event.value === '1') {
        // this.result.stamp.kind = "verbalni znak"
        this.izabranaVrednost = "verbalni znak";
        this.isHiddenOtherKind = true
        this.isVerbalniZnak = false;
        this.isStraniJezik = true;
    } else if ($event.value === '2') {
        // this.result.stamp.kind = "grafički znak"
        this.izabranaVrednost = "grafički znak";
        this.isHiddenOtherKind = true
        this.isVerbalniZnak = true;
        this.isStraniJezik = true;
    } else if ($event.value === '3') {
        // this.result.stamp.kind = "kombinovani znak"
        this.izabranaVrednost = "kombinovani znak";
        this.isHiddenOtherKind = true
        this.isVerbalniZnak = true;
        this.isStraniJezik = true;
    } else if ($event.value === '4') {
        // this.result.stamp.kind = "trodimenzionalni znak"
        this.izabranaVrednost = "trodimenzionalni znak";
        this.isHiddenOtherKind = true
        this.isVerbalniZnak = true;
        this.isStraniJezik = true;
    } else if ($event.value === '5'){
        this.izabranaVrednost = "druga vrsta znaka";
        this.isHiddenOtherKind = false
        this.isVerbalniZnak = true;
        this.isStraniJezik = true;
    }
}

optionChangedVerbalniZnak($event: MatRadioChange) {
  if ($event.value === '1') {
    this.isStraniJezik = true;
  } else  {
    this.isStraniJezik = false;
  }
}


next() {
  // this.form.get('tip_ziga')!.markAllAsTouched();
  // this.form.get('tip_ziga')!.updateValueAndValidity();

  this.zahtev.tip_ziga = this.izabranaVrednost;

  if (this.izabranaVrednost == "druga vrsta znaka") {
    this.zahtev.tip_ziga = this.druga_vrsta_znaka;
  }

  if (this.izabranaVrednost == "verbalni znak" && this.isStraniJezik == false) {
    this.zahtev['transliteracija'] = this.transliteracija;
    this.zahtev['prevod'] = this.prevod;
  }

  console.log(this.zahtev)

  // for (const key in podnosilacValues) {
  //   if (podnosilacValues[key] && !adresaFileds.includes(key)) {
  //     this.zahtev.podnosilac[key] = podnosilacValues[key];
  //   }
  // }
}

}
